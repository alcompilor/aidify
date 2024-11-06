import { PromptBuilder } from './classes/PromptBuilder';
import { Locale, ParticipantData, PromptType } from './types';
import { Payload } from './classes/Payload';
import { calcAbuseRisk } from './utilities/calcAbuseRisk';
import { getOrganizations } from './utilities/getOrganizations';

export interface Env {
	LLAMA_MODEL: string;
	AI: any;
}

export default {
	async fetch(request: Request, env: Env) {
		if (request.method !== 'POST') {
			return Response.json(new Payload('Method not allowed', 405), { status: 405 });
		}

		if (request.headers.get('Content-Type') !== 'application/json') {
			return Response.json(new Payload('A JSON body is required', 422), { status: 422 });
		}

		const req = await request.json();

		const locale: Locale = req.locale ?? 'en';
		const payload: ParticipantData = req.payload;

		if (!areFieldsValid(payload)) {
			return Response.json(new Payload('Invalid or missing fields', 400), { status: 400 });
		}

		const promptBuilder: PromptBuilder = new PromptBuilder();

		const openQuestionsRes = await executeQuery(
			promptBuilder.systemPrompt(PromptType.OPEN_QUESTIONS, locale),
			`1: ${payload.openQuestions.q1}\n2: ${payload.openQuestions.q2}`,
			env
		);

		const symptomsRes = await executeQuery(
			promptBuilder.systemPrompt(PromptType.SYMPTOMS, locale, payload.misuseType),
			`${payload.symptoms}`,
			env
		);

		const resData: ParticipantData = {
			...payload,
			result: {
				summary: {
					feedback: openQuestionsRes,
					assessment: symptomsRes,
					abuseRisk: calcAbuseRisk(payload.uncopeQuestions, locale),
				},
				organizations: getOrganizations(payload.misuseType, locale),
			},
		};
		return Response.json(new Payload(resData, 200), { status: 200 });
	},
};

const areFieldsValid = (payload: ParticipantData): boolean => {
	if (
		typeof payload.misuseType === 'string' &&
		typeof payload.openQuestions === 'object' &&
		typeof payload.uncopeQuestions === 'object' &&
		typeof payload.symptoms === 'string'
	) {
		const values = [
			payload.misuseType,
			...Object.values(payload.openQuestions),
			...Object.values(payload.uncopeQuestions),
			payload.symptoms,
		];
		return values.every((value) => value !== null && value !== undefined);
	}
	return false;
};

const executeQuery = async (systemPrompt: string, userPrompt: string, env: Env) => {
	const query = {
		messages: [
			{ role: 'system', content: systemPrompt },
			{ role: 'user', content: userPrompt },
		],
	};

	const { response } = await env.AI.run(`@cf/meta/${env.LLAMA_MODEL}`, query);
	return response;
};
