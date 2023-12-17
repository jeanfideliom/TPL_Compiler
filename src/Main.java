import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main extends JFrame {
    private JButton openFileButton;
    private JButton lexicalAnalysisButton;
    private JButton semanticAnalysisButton;
    private JButton syntaxAnalysisButton;
    private JTextArea srcText;
    private JTextField resultTextField;
    private JPanel window;
    private JButton clearButton;
    private File file;
    private String contents;
    private lexicalAnalysis lexicalAnalysis;
    private String lexOutput;


    public Main() {

        lexicalAnalysisButton.setEnabled(false);
        syntaxAnalysisButton.setEnabled(false);
        semanticAnalysisButton.setEnabled(false);
        clearButton.setEnabled(false);
        srcText.setFocusable(false);
        resultTextField.setFocusable(false);

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int srcVal = fileChooser.showOpenDialog(null);

                if (srcVal == JFileChooser.APPROVE_OPTION) {
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    try {
                        contents = Files.readString(file.toPath());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    srcText.setText(contents);
                    lexicalAnalysisButton.setEnabled(true);
                    clearButton.setEnabled(true);
                }
            }
        });
        lexicalAnalysisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lexicalAnalysis = new lexicalAnalysis();
                lexOutput = lexicalAnalysis.lexicalAnalysis(contents);
                resultTextField.setText(lexOutput);


            }
        });

    }

    public static void main(String[] args) {
        Main compiler = new Main();
        compiler.setContentPane(new Main().window);
        compiler.setDefaultCloseOperation(EXIT_ON_CLOSE);
        compiler.setSize(700, 500);
        compiler.setVisible(true);
        compiler.pack();

    }
}
