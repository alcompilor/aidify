import { Locale, UncopeQuestions } from '../types';

export const calcAbuseRisk = (uncopeQuestions: UncopeQuestions, locale: Locale): string => {
	const positiveCount = Object.values(uncopeQuestions).filter((answer) => answer).length ?? 0;
	let riskLevel = locale === 'en' ? 'Low' : 'Låg';

	if (positiveCount >= 2) {
		switch (positiveCount) {
			case 2:
				riskLevel = locale === 'en' ? 'Substantial' : 'Väsentlig';
				break;
			case 3:
				riskLevel = locale === 'en' ? 'High' : 'Hög';
				break;
			case 4:
			case 5:
			case 6:
				riskLevel = locale === 'en' ? 'Severe' : 'Allvarlig';
				break;
			default:
				break;
		}
	}

	return riskLevel;
};
