export interface ParticipantData {
	misuseType: MisuseType;
	openQuestions: OpenQuestions;
	uncopeQuestions: UncopeQuestions;
	symptoms: string;
	result: Result;
	locale: Locale;
}

export enum MisuseType {
	ALCOHOL = 'ALCOHOL',
	SUBSTANCE = 'SUBSTANCE',
}

export interface OpenQuestions {
	q1: string;
	q2: string;
}

export interface UncopeQuestions {
	q1: boolean;
	q2: boolean;
	q3: boolean;
	q4: boolean;
	q5: boolean;
	q6: boolean;
}

export interface Result {
	summary: Summary;
	organizations: Organization[] | [];
}

export interface Summary {
	feedback: string;
	assessment: string;
	abuseRisk: string;
}

export interface Organization {
	name: string;
	phone: string;
	email: string;
	address: string;
	website: string;
	description: string | null;
}

export enum PromptType {
	OPEN_QUESTIONS,
	SYMPTOMS,
}

export type Locale = 'sv' | 'en';
