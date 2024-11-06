import { Locale, MisuseType, Organization } from '../types';

export const getOrganizations = (misuseType: MisuseType, locale: Locale) => {
	const alcoholOrgs: Organization[] = [
		{
			name: locale === 'en' ? 'Alcoholics Anonymous' : 'Anonyma Alkoholister',
			description:
				locale === 'en'
					? 'A global community supporting individuals in achieving sobriety through meetings and the concept of Twelve Steps.'
					: 'En global gemenskap som stöder individer i att uppnå nykterhet genom möten och konceptet Tolv Steg.',
			email: 'help@aa.se',
			phone: '08-720 38 42',
			address: 'Bolidenvägen 20, Johanneshov. Box 92171. 120 08 Stockholm',
			website: 'https://www.aa.se',
		},
		{
			name: 'Alkoholhjälpen',
			description:
				locale === 'en'
					? 'An organisation that provides anonymous, free support online and by phone, available nationwide. They are not part of the healthcare system, so you are responsible for seeking care if needed.'
					: 'En organisation som erbjuder anonymt och kostnadsfritt stöd via nätet och telefon, tillgängligt för alla i hela landet. De är inte en del av sjukvården, så du ansvarar själv för att söka vård om det behövs.',
			email: 'kontakt@alkoholhjalpen.se',
			phone: '020-84 44 48',
			address: 'N/A',
			website: 'https://alkoholhjalpen.se',
		},
	];

	const substanceOrgs: Organization[] = [
		{
			name: locale === 'en' ? 'Narcotics Anonymous' : 'Anonyma Narkomaner',
			description:
				locale === 'en'
					? 'A nonprofit community of recovering addicts who meet to support each other in staying drug-free. Membership requires only a desire to stop using.'
					: 'En ideell gemenskap av tillfrisknande beroende som möts för att stödja varandra i att förbli drogfria. Medlemskap kräver endast en önskan att sluta använda.',
			email: 'info@nasverige.org',
			phone: '0771-13 80 00',
			address: 'Ranhammarsvägen 20, 168 67 Bromma',
			website: 'https://www.nasverige.org',
		},
		{
			name: 'Droghjälpen',
			description:
				locale === 'en'
					? `An organisation that provides anonymous support for those questioning their own or someone else's drug use. Advisors are available online and by phone without the need for personal information.`
					: 'En organisation som erbjuder anonymt stöd för dem som funderar på sin eller någon annans droganvändning. Rådgivare finns tillgängliga online och via telefon utan krav på personuppgifter.',
			email: 'kontakt@alkoholhjalpen.se',
			phone: '020-84 44 48',
			address: 'N/A',
			website: 'https://droghjalpen.se',
		},
	];

	return misuseType === MisuseType.ALCOHOL ? alcoholOrgs : substanceOrgs;
};
