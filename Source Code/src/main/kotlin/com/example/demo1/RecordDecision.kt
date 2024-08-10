package com.example.demo1

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.DatePicker
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class RecordDecision {
    @FXML
    private lateinit var  consequence: TextArea

    @FXML
    private lateinit var context: TextArea

    @FXML
    private lateinit var date: DatePicker

    @FXML
    private lateinit var decision: TextArea

    @FXML
    private var rejectionReason: TextArea? = null

    @FXML
    private lateinit var status: TextField

    @FXML
    private lateinit var title: TextField


    @FXML
    private lateinit var  saveMessage: Label

    @FXML
    fun clickedSaveAll(event: MouseEvent?) {
        val titleInput = title.text
        val dateInput = date.value
        val contextInput = context.text
        val consequenceInput = consequence.text
        val decisionInput = decision.text
        val statusInput = status.text
        val rejectionReasonInput = rejectionReason?.text

        val saveHandler = SaveHandler()
        saveHandler.saveDecision(
            titleInput,
            dateInput,
            contextInput,
            consequenceInput,
            decisionInput,
            statusInput,
            rejectionReasonInput
        )

        if (titleInput.isNullOrEmpty() || dateInput==null || dateInput.toString().isNullOrEmpty() || contextInput.isNullOrEmpty() || consequenceInput.isNullOrEmpty() || decisionInput.isNullOrEmpty() || statusInput.isNullOrEmpty()){
            saveMessage.text = "Field Cannot be Empty"
        } else {
            saveMessage.text = "Successfully Recorded"
        }
    }

    @FXML
    fun record_To_Mainpage(event: MouseEvent?) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("main_page.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = (event?.source as Node).scene.window as Stage
        stage.scene = scene
        stage.show()
    }
}