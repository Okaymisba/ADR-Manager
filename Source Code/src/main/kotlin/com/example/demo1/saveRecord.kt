package com.example.demo1

import java.io.File
import java.time.LocalDate

class SaveHandler {

    fun saveDecision(
        title: String,
        date: LocalDate,
        context: String,
        consequence: String,
        decision: String,
        status: String,
        rejectionReason: String?
    ) {
        val decisionsDir = File("Decisions")
        if (!decisionsDir.exists()) {
            decisionsDir.mkdir()
        }

        val formattedTitle = title.replace("\\s+".toRegex(), "-")
        val fileName = String.format("%04d-%s.txt", getNextFileIndex(decisionsDir), formattedTitle)
        val decisionFile = File(decisionsDir, fileName)

        decisionFile.writeText(buildString {
            appendLine(" TITLE:")
            appendLine("     $title")
            appendLine(" DATE:")
            appendLine("     $date")
            appendLine(" STATUS:")
            appendLine("     $status")
            if (!rejectionReason.isNullOrEmpty()) {
                appendLine(" REASON:")
                appendLine("     $rejectionReason")
            }
            appendLine(" CONTEXT:")
            appendLine("     $context")
            appendLine(" DECISION:")
            appendLine("     $decision")
            appendLine(" CONSEQUENCES:")
            appendLine("     $consequence")
        })
    }

    private fun getNextFileIndex(decisionsDir: File): Int {
        val files = decisionsDir.listFiles()
        return if (files != null && files.isNotEmpty()) {
            val highestIndex = files.mapNotNull {
                it.name.takeWhile { char -> char.isDigit() }.toIntOrNull()
            }.maxOrNull()
            (highestIndex ?: 0) + 1
        } else {
            1
        }
    }
}
