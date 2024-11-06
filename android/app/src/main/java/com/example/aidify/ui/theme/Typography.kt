package com.example.aidify.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.aidify.models.CustomTypography

val Typography = CustomTypography(
    // Headline for the screen (equivalent to h1 or h2).
    headline = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 34.sp,
        lineHeight = 42.sp,
        letterSpacing = (-0.4).sp
    ),

    // Sub-headline for the large headline.
    subheadline = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 26.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.sp
    ),

    // Title for sections like Summary (equivalent to h3 or h4).
    section = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // Title for displaying key points, questions, etc.
    highlight = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // Text for input fields, etc.
    input = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.25.sp
    ),

    // Text for paragraphs.
    paragraph = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 17.5.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.2.sp
    ),

    // Label for buttons, links, etc.
    clickable = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),

    // Label for notifications like warnings and errors.
    notice = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),

    // Label for tags, badges, annotations, etc.
    tag = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
)