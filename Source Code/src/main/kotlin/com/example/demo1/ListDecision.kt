package com.example.demo1

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class ListDecision {
    @FXML
    private val listTomain: Button? = null

    @FXML
    fun list_To_Mainpage(event: MouseEvent?) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("main_page.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = (event?.source as Node).scene.window as Stage
        stage.scene = scene
        stage.show()
    }
}