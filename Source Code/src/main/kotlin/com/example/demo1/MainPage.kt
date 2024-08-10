package com.example.demo1

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.text.Text
import javafx.stage.Stage

class MainPage {
    @FXML
    private val TextArchDecRec: Text? = null

    @FXML
    private val listDecision: Button? = null

    @FXML
    private val recordDecision: Button? = null

    @FXML
    fun clickedListDecision(event: MouseEvent?) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("list_decision.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = (event?.source as Node).scene.window as Stage
        stage.scene = scene
        stage.show()
    }

    @FXML
    fun clickedRecordDecision(event: MouseEvent?) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("record_decision.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = (event?.source as Node).scene.window as Stage
        stage.scene = scene
        stage.show()
    }
}