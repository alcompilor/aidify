package com.example.aidify.assets

import com.example.aidify.models.EducationalLibraryCard
import com.example.aidify.models.CardCategory
import com.example.aidify.models.CardMediaType

object cardsData {
    val cards = listOf(
        EducationalLibraryCard(
            title = "Alcohol use disorder",
            description = "Alcohol Use Disorder (AUD), describing a pattern of alcohol consumption that leads to significant health and social problems. Symptoms include difficulty controlling alcohol intake, increased tolerance, withdrawal symptoms, and continued drinking despite negative consequences.",
            link = "https://www.mayoclinic.org/diseases-conditions/alcohol-use-disorder/symptoms-causes/syc-20369243",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.ALCOHOL
        ),
        EducationalLibraryCard(
            title = "Alcohol Use and Your Health",
            description = "The Centers for Disease Control and Prevention (CDC) outlines the short- and long-term health effects of excessive drinking. This includes everything from injuries and risky behaviors to chronic diseases like liver cirrhosis and certain cancers.",
            link = "https://www.cdc.gov/alcohol/about-alcohol-use/index.html",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.ALCOHOL
        ),
        EducationalLibraryCard(
            title = "Alcohol Use and Abuse",
            description = "MedlinePlus provides a detailed description of alcohol abuse, covering symptoms, diagnosis, treatment options, and the importance of support groups in recovery.",
            link = "https://medlineplus.gov/alcoholusedisorderaud.html",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.ALCOHOL
        ),
        EducationalLibraryCard(
            title = "Understanding the Dangers of Alcohol Overdose",
            description = "NIH stresses the importance of recognizing overdose symptoms and acting quickly by seeking medical help, while providing tips on how to assist someone in this situation.",
            link = "https://www.niaaa.nih.gov/publications/brochures-and-fact-sheets/understanding-dangers-of-alcohol-overdose",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.ALCOHOL
        ),
        EducationalLibraryCard(
            title = "Drug Use and Addiction",
            description = "MedlinePlus explains the basics of drug use and addiction. Drugs are substances that alter how the body or mind functions and include both legal (prescription, over-the-counter) and illegal substances. Drug use can involve illegal substances or the misuse of legal drugs (e.g., taking larger doses or using them for non-medical purposes).",
            link = "https://medlineplus.gov/druguseandaddiction.html",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.SUBSTANCE
        ),
        EducationalLibraryCard(
            title = "How drugs affect your body",
            description = "outlines how different drugs affect the body in various ways, with both short-term and long-term impacts that can be physical and psychological. The effects depend on factors like body size, health, drug strength, and other drugs taken concurrently.",
            link = "https://www.betterhealth.vic.gov.au/health/healthyliving/How-drugs-affect-your-body",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.SUBSTANCE
        ),
        EducationalLibraryCard(
            title = "Drug addiction (substance use disorder)",
            description = "provides an overview of drug addiction, also known as substance use disorder, describing it as a disease that impacts the brain and behavior, leading to an inability to control the use of drugs, whether legal or illegal. It outlines how addiction can begin with experimental use in social situations or through prescribed medications, particularly opioids.",
            link = "https://www.mayoclinic.org/diseases-conditions/drug-addiction/symptoms-causes/syc-20365112",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.SUBSTANCE
        ),
        EducationalLibraryCard(
            title = "Drug Addiction Recovery Through First Hand Experiences",
            description = "explores the experiences of individuals in different stages of drug addiction recovery, aiming to deepen the understanding of recovery processes beyond conventional treatment settings. Conducted through 30 in-depth qualitative interviews in the Netherlands, the study includes a balanced representation of men and women, with participants classified into three recovery stages.",
            link = "https://pmc.ncbi.nlm.nih.gov/articles/PMC10426251/",
            mediaType = CardMediaType.ARTICLE,
            category = CardCategory.SUBSTANCE
        ),
        EducationalLibraryCard(
            title = "Educational Videos",
            description = "A List of educational videos covering the most important topics",
            link = "https://www.can.se/nationell-fordjupningskurs-forstarkt-barn-och-foraldraperspektiv-vid-missbruk-och-beroende/utbildningsfilmer/",
            mediaType = CardMediaType.VIDEO,
            category = CardCategory.ALCOHOL
        )
    )
}