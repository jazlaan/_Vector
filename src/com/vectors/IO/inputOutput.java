package com.vectors.IO;

import com.vectors.userInterface;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;


public class inputOutput {



    public static void saveFile() {
        JFileChooser chooseFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        chooseFile.setAcceptAllFileFilterUsed(false);
        chooseFile.setDialogTitle("Save .vec file");
        FileNameExtensionFilter restrict = new FileNameExtensionFilter(".vec files", "vec");
        chooseFile.addChoosableFileFilter(restrict);
        if(chooseFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File saveFile;
            saveFile = chooseFile.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(saveFile+".vec");
                for(String str: userInterface.content){
                    writer.write(str);
                }
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
