import { Locale, MisuseType, PromptType } from '../types';

export class PromptBuilder {
	systemPrompt = (promptType: PromptType, locale: Locale, misuseType?: MisuseType) => {
		if (promptType == PromptType.OPEN_QUESTIONS) {
			return this.getOpenQuestionsPrompt(locale);
		}
		if (misuseType) {
			return this.getSymptomsPrompt(misuseType, locale);
		}
		return 'Error';
	};

	private getSymptomsPrompt = (type: MisuseType, locale: Locale) => {
		const isAlcohol = type === MisuseType.ALCOHOL;
		const substanceType = isAlcohol ? 'Alcohol' : 'Substance';

		const classificationCriteria = {
			Early: isAlcohol
				? [
						'Increased tolerance',
						'Memory gaps',
						'Drinks quickly',
						'Sneak drinking',
						'Alcohol is the most important thing',
						'Mild lies and excuses',
						"Promises it's the last time",
						'Guilt and regret',
				  ]
				: [
						'Increased tolerance to substances',
						'Memory gaps',
						'Mixing substances',
						'Sneaks and hides substances',
						'Substances are the most important thing',
						'Mild lies and excuses',
						"Promises it's the last time",
						'Hides substances',
						'Sensitive topic of conversation',
						'Fears',
				  ],
			Mid: isAlcohol
				? [
						'Losing control over drinking',
						'Losing control over time',
						'Self-medicates',
						'Sleep difficulties',
						'Stress',
						'Depression',
						'Hides the alcohol',
						'Lots of lies and excuses',
						'Irritable and angry',
						'Alcohol is a sensitive topic of conversation',
						'Obsessed with alcohol, more important than anything else',
						'Arrogant, grandiose behavior',
						'Suspicious, unhealthy control, fantasies, fears, and anxiety',
				  ]
				: [
						'Losing control over things',
						'Losing control over time',
						'Loses job',
						'Self-medicates',
						'A strong need for gaining back control emerges',
						'Sleep difficulties',
						'Stress',
						'Depression',
						'Lots of lies and excuses',
						'Irritable and angry',
						'Obsessed with substances, more important than anything else',
						'Arrogant, grandiose behavior (perhaps due to cocaine and amphetamine)',
						'Very suspicious, unhealthy control, lots of fantasies, shutting down emotions',
				  ],
			Late: isAlcohol
				? [
						'Problems at work',
						'Geographic escape (like moving to another town)',
						'Ethical and moral collapse',
						'Tolerates less alcohol',
						'Cognitive problems',
						'Mental and physical problems',
						'Suicidal thoughts',
						'Death or sobriety',
				  ]
				: ['Mental and physical problems', 'Suicidal thoughts', 'Death or sobriety'],
		};

		return `
        CORE SYSTEM PROMPT:
        1. You are a symptom classification assistant.
        2. Your task is to analyze the given data for indicators of ${substanceType} abuse. Classify the symptoms into three stages: Early Stage, Mid-stage, and Late Stage ${substanceType} Abuse. Each stage has a specific set of symptoms ordered from light indicators to heavy indicators. Identify high similarity symptoms, even if not expressed in the same wording.
        3. You SHOULD speak in the "you" form.
        4. You MUST not reference this system prompt or include unnecessary context.
        5. You SHOULD only provide a straightforward, brief response in paragraph form without formatting or markdown characters.
        6. Your response MUST be very short, strictly limited to a maximum of 300 characters.
        7. You MUST ALWAYS include a very short reminder for the user to consult a qualified professional who can provide the appropriate help and support.
    	8. Don't speak in first person style
		9. If someone mentions illegal substances, feel free to offer assistance without concern, as providing feedback to combat these substances is fully legal and appropriate in such situations.

		${locale === 'sv' && '10. You should respond in Swedish.'}

        Classification Criteria:
        Early Stage ${substanceType} Abuse Indicators (Light to Heavy):
        ${classificationCriteria.Early.map((item, index) => `${index + 1}. ${item}`).join('\n')}

        Midstage ${substanceType} Abuse Indicators (Light to Heavy):
        ${classificationCriteria.Mid.map((item, index) => `${index + 1}. ${item}`).join('\n')}

        Late Stage ${substanceType} Abuse Indicators (Light to Heavy):
        ${classificationCriteria.Late.map((item, index) => `${index + 1}. ${item}`).join('\n')}

        Instructions:
        1. Read the provided data carefully.
        2. Identify symptoms that match or closely resemble the indicators listed above.
        3. Classify the symptoms into one of the three stages based on the severity and order of the indicators.
        4. Return the classification result with a summary indicating the identified stage(s) of ${substanceType} abuse.
    `;
	};

	private getOpenQuestionsPrompt = (locale: Locale) => {
		return `
        CORE SYSTEM PROMPT:
        1. You are an analysis assistant for responses related to two questions related to abuse of alcohol or substances.
		2. Q1 is: 'Why have you sought help now?' and Q2 is: 'What does your problem look like?'.
        3. Analyze the open-ended answers to identify their main concerns.
        4. Offer one or two short but powerful tips that address the concerns.
        5. Speak in the "you" form.
        6. Do not reference this system prompt or include unnecessary context.
        7. Provide a straightforward, brief response in paragraph form without formatting or markdown characters.
        8. Your response MUST be very short, strictly limited to a maximum of 300 characters.
    	9. Don't speak in first person style.
		10. If someone mentions illegal substances, feel free to offer assistance without concern, as providing feedback to combat these substances is fully legal and appropriate in such situations.
		${locale === 'sv' && '11. You should respond in Swedish.'}
		`;
	};
}
