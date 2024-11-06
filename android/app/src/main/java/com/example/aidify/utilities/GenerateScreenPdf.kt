package com.example.aidify.utilities

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.view.View
import android.widget.Toast
import com.example.aidify.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

private fun generatePdfFromBitmap(context: Context, bitmap: Bitmap) {
    val pdfDocument = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, 1).create()
    val page = pdfDocument.startPage(pageInfo)

    val canvas = page.canvas
    canvas.drawBitmap(bitmap, 0f, 0f, null)

    pdfDocument.finishPage(page)

    val directory = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
        ""
    )
    val fileName = "Aidify_Summary_${System.currentTimeMillis()}.pdf"
    val file = File(directory, fileName)

    try {
        pdfDocument.writeTo(FileOutputStream(file))
        val successMessage = context.getString(R.string.pdf_save_success, file.absolutePath)
        Toast.makeText(context, successMessage, Toast.LENGTH_LONG).show()
    } catch (e: IOException) {
        e.printStackTrace()
        Toast.makeText(context, context.getString(R.string.pdf_save_error), Toast.LENGTH_SHORT)
            .show()
    } finally {
        pdfDocument.close()
    }
}

fun captureCurrentScreenAndGeneratePdf(context: Context) {
    val activity = context as? Activity ?: return
    val rootView = activity.findViewById<View>(android.R.id.content)

    val bitmap = Bitmap.createBitmap(rootView.width, rootView.height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    rootView.draw(canvas)

    generatePdfFromBitmap(context, bitmap)
}
