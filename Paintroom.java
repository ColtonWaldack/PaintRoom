import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.io.File;
import java.io.FileWriter;

// Colton Waldack 12/12/2020


public class Paintroom extends JFrame implements ActionListener {
    private JCheckBox paintpreBox,paintpreBox2, paintpreBox3, paintpreBox4 ;
    private JComboBox paintcolorCombo ,tapeCombo, paintcolorCombo2, paintcolorCombo3, paintcolorCombo4;
    private JPanel northPanel, commentPanel, brushPanel, colorPanel,centerPanel, westPanel, customerinfoPanel, eastPanel, submittedPanel, southPanel;
    private ImageIcon hdIcon, hdIcon2, brushpremiumIcon, brushregularIcon;
    private JLabel brushregLable, tapeLabel, brushpreLabel, paintLabel, paintLabel2, brushLabel,colorLabel, colorLabel2, colorLabel3, colorLabel4,  hdIconLabel, nameLabel, addyLabel, emailLabel, stateLabel, zipLabel, commentsLabel;
    private JTextField fullnameTextField, addyTextField, stateTextField, zipTextField, emailTextField;
    private JTextArea commentsArea;
    private JRadioButton brushregRadio, brushpreRadio;
    private JButton payButton, clearButton;
    private GridLayout MyGridLayoutColor = new GridLayout (6,3);
    private GridLayout MyGridLayoutInfo = new GridLayout (6,2);
    private GridLayout MyGridLayoutBrush = new GridLayout (2,2);
    // private GridLayout MyGridLayoutSubmitted = new GridLayout (9,3);
    private ButtonGroup brushGroup;
    private Border blackline = BorderFactory.createLineBorder(Color.black);
    private String paintList [] = {"None", "Red", "Blue","White","Yellow","Brown","Gray"};
    private String URL = "jdbc:mysql://localhost/Paintroom?user=root&password=";



    public Paintroom() {
        super("Home Depot PaintRoom");

//-----------------Initial Pop-up Message---------------------------------
        hdIcon2 = new ImageIcon("hdicon.jpg");
        JOptionPane.showMessageDialog(null,
                "Introducing Home Depot PaintRoom." +
                        "\n " +
                        "\nThis application is designed to allow cutomers to order pre-built kits for all of their painting needs." +
                        "\nCustomers can order up to four diffrent paint colors, along with brushes and tape!" +
                        "\n " +
                        "\n "+
                        "\n "+
                        "\n "+
                        "\n "+
                        "\n Created by Colton Waldack 10/10/2020",
                "Welcome To Home Depot PaintRoom",
                JOptionPane.INFORMATION_MESSAGE, hdIcon2);
//------------------------------------------------------------------------------



// North Panel-------------------------------------------------
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());

        hdIcon = new ImageIcon("HDlogo.jpg");
        hdIconLabel = new JLabel(hdIcon);

        northPanel.add(hdIconLabel, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);
//------------------------------------------------------------

//CustomerInfoPanel------------------------------------------------------
        customerinfoPanel = new JPanel();
        customerinfoPanel.setLayout(MyGridLayoutInfo);
        customerinfoPanel.setBackground(Color.lightGray);

        MyGridLayoutInfo.setHgap(0);
        MyGridLayoutInfo.setVgap(5);

        //welcomeLabel = new JLabel("Welcome, Please enter your information to get started");
        nameLabel = new JLabel("Full-Name:");
        emailLabel = new JLabel("Email: ");
        addyLabel = new JLabel("Address:");
        stateLabel = new JLabel("State:");
        zipLabel = new JLabel("Zipcode:");

        fullnameTextField = new JTextField(10);
        emailTextField = new JTextField(10);
        addyTextField = new JTextField(10);
        stateTextField = new JTextField(10);
        zipTextField = new JTextField(10);


        customerinfoPanel.add(zipLabel, 5,0);
        customerinfoPanel.add(zipTextField, 5,1);

        customerinfoPanel.add(stateLabel, 4,0);
        customerinfoPanel.add(stateTextField, 4,1);

        customerinfoPanel.add(addyLabel, 3,0);
        customerinfoPanel.add(addyTextField, 3,1);

        customerinfoPanel.add(emailLabel, 2,0);
        customerinfoPanel.add(emailTextField, 2,1);

        customerinfoPanel.add(nameLabel, 1,0);
        customerinfoPanel.add(fullnameTextField, 1,1);
        customerinfoPanel.setBorder(blackline);
//--------------------------------------------------------------


//colorPanel ------------------------------------------------------
        colorPanel = new JPanel();
        colorPanel.setLayout(MyGridLayoutColor);
        colorPanel.setBorder(blackline);
        colorPanel.setBackground(Color.lightGray);

        MyGridLayoutColor.setHgap(0);
        MyGridLayoutColor.setVgap(5);

        paintLabel = new JLabel("Customer Info & Paint Selection");
        paintLabel2 = new JLabel("Use the comboboxes below to select up to four colours.");
        tapeLabel = new JLabel("# Rolls of Tape");


        String tapeList [] = {"0" ,"1", "2", "3", "4", "5", "6"};

        paintcolorCombo = new JComboBox(paintList);
        paintcolorCombo2 = new JComboBox(paintList);
        paintcolorCombo3 = new JComboBox(paintList);
        paintcolorCombo4 = new JComboBox(paintList);
        tapeCombo = new JComboBox(tapeList);

        paintpreBox = new JCheckBox("Premium Paint? ");
        paintpreBox2 = new JCheckBox("Premium Paint? ");
        paintpreBox3 = new JCheckBox("Premium Paint? ");
        paintpreBox4 = new JCheckBox("Premium Paint? ");

        paintpreBox.setBackground(Color.lightGray);
        paintpreBox2.setBackground(Color.lightGray);
        paintpreBox3.setBackground(Color.lightGray);
        paintpreBox4.setBackground(Color.lightGray);

        colorLabel = new JLabel("Color #1 :");
        colorLabel2 = new JLabel("Color #2 :");
        colorLabel3 = new JLabel("Color #3 :");
        colorLabel4 = new JLabel("Color #4 :");

        colorPanel.add(tapeLabel, 0,0);
        colorPanel.add(tapeCombo, 0,1);

        colorPanel.add(colorLabel4, 1,0);
        colorPanel.add(paintcolorCombo4, 1,1);
        colorPanel.add(paintpreBox4, 1,2);

        colorPanel.add(colorLabel3, 2,0);
        colorPanel.add(paintcolorCombo3, 2,1);
        colorPanel.add(paintpreBox3, 1,2);

        colorPanel.add(colorLabel2, 3,0);
        colorPanel.add(paintcolorCombo2, 3,1);
        colorPanel.add(paintpreBox2, 1,2);

        colorPanel.add(colorLabel, 4,0);
        colorPanel.add(paintcolorCombo, 4,1);
        colorPanel.add(paintpreBox, 1,2);
//--------------------------------------------------------------


//WestPanel ------------------------------------------------------
        westPanel = new JPanel();
        westPanel.setLayout(new BorderLayout());
        westPanel.setBackground(Color.orange);
        westPanel.add(paintLabel, BorderLayout.NORTH);
        westPanel.add(customerinfoPanel, BorderLayout.CENTER);
        westPanel.add(colorPanel, BorderLayout.SOUTH);
        add(westPanel, BorderLayout.WEST);
//--------------------------------------------------------------

//BrushPanel ------------------------------------------------------
        brushPanel = new JPanel();
        brushPanel.setLayout(MyGridLayoutBrush);
        brushPanel.setBackground(Color.lightGray);
        brushGroup = new ButtonGroup();
        brushPanel.setBorder(blackline);

        MyGridLayoutBrush.setHgap(0);
        MyGridLayoutBrush.setVgap(0);

        brushregularIcon = new ImageIcon("brushreg.png");
        brushpremiumIcon = new ImageIcon("brushpre.png");

        brushregLable = new JLabel(brushregularIcon);
        brushpreLabel = new JLabel(brushpremiumIcon);

        brushregRadio = new JRadioButton("Regular Brush");
        brushpreRadio = new JRadioButton("Premium-Hair Brush");
        brushpreRadio.setBackground(Color.lightGray);
        brushregRadio.setBackground(Color.lightGray);

        brushGroup.add(brushregRadio);
        brushGroup.add(brushpreRadio);

        brushPanel.add(brushregLable, 0,0);
        brushPanel.add(brushpreLabel, 0,1);

        brushPanel.add(brushregRadio, 1,0);
        brushPanel.add(brushpreRadio,1,1);
//--------------------------------------------------------------

//CommentPanel--------------------------------------------------------------
        commentPanel = new JPanel();
        commentPanel.setLayout(new GridLayout(1,2));
        commentPanel.setBackground(Color.lightGray);
        commentPanel.setBorder(blackline);

        commentsLabel = new JLabel("Order Comments:");

        commentsArea = new JTextArea(5,5);
        commentsArea.setLineWrap(true);

        commentPanel.add(commentsLabel, 0,0);
        commentPanel.add(commentsArea, 0,1);
//--------------------------------------------------------------


//Center Panel------------------------------------------------------
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        brushLabel = new JLabel("Brush Selection");
        centerPanel.setBackground(Color.orange);
        centerPanel.add(brushLabel, BorderLayout.NORTH);
        centerPanel.add(brushPanel, BorderLayout.CENTER);
        centerPanel.add(commentPanel,BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
//--------------------------------------------------------------

//East Panel------------------------------------------------------
        // eastPanel = new JPanel();
        //add(eastPanel, BorderLayout.EAST);
//--------------------------------------------------------------


// South Panel--------------------------------------------------------
        southPanel = new JPanel();
        payButton = new JButton("Submit Paint Request");
        payButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        southPanel.add(payButton);
        southPanel.add(clearButton);

        add(southPanel, BorderLayout.SOUTH);
//------------------------------------------------------------------------------------

        setVisible(true);
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//---------End of Constructor---------------------------------------------------------------------------

    //---------Action Listener---------------------------------------------------------------------------
    public void actionPerformed(ActionEvent event) {

        try {
            Class.forName("com.mysql.jdbc.Driver");


            Connection con = DriverManager.getConnection(URL);





            if (event.getSource() == payButton) {
                String fullname = fullnameTextField.getText();
                String email = emailTextField.getText();
                String addy = addyTextField.getText();
                String state = stateTextField.getText();
                String zip = zipTextField.getText();
                String color1 = "";
                String color2 = "";
                String color3 = "";
                String color4 = "";
                String brushtype = "None";
                Integer paintcount = 0;
                Integer tapecount = 0;
                String comment = commentsArea.getText();
                try {
                    if (fullname.equals("") || email.equals("") || addy.equals("") || state.equals("") || zip.equals("")){
                        throw new EntryException("ERROR!! YOU MUST ENTER A VALUE IN ALL INFROMATION BOXES");

                    }


                    if (brushregRadio.isSelected()) {
                        brushtype = "Regular Brush";

                    } else if (brushpreRadio.isSelected()) {
                        brushtype = "Premium Brush";
                    }



                    if (!paintcolorCombo.getSelectedItem().equals("None")) {
                        paintcount++;
                        color1 = paintList[paintcolorCombo.getSelectedIndex()];
                    }
                    if (!paintcolorCombo2.getSelectedItem().equals("None")) {
                        paintcount++;
                        color2 = paintList[paintcolorCombo2.getSelectedIndex()];
                    }
                    if (!paintcolorCombo3.getSelectedItem().equals("None")) {
                        paintcount++;
                        color3 = paintList[paintcolorCombo3.getSelectedIndex()];
                    }
                    if (!paintcolorCombo4.getSelectedItem().equals("None")) {
                        paintcount++;
                        color4 = paintList[paintcolorCombo4.getSelectedIndex()];
                    }
                    if (!tapeCombo.getSelectedItem().equals("0")) {
                        tapecount = tapeCombo.getSelectedIndex();
                    }
                    String sqlStatement = "insert into receipt (fullname, email, address, state, zip, paintcount, colorone, colortwo, colorthree, colorfour, tapecount, brushtype, comments) values (" + "\'" + fullname + "\'" + "  ," + "\'" + email + "\'" + " ," + "\'" + addy + "\'" + " ," + "\'" + state + "\'" + " ," + "\'" + zip + "\'" + ", " + "\'" + paintcount + "\'" + "  ," + "\'" + color1 + "\'" + " ," + "\'" + color2 + "\'" + " ," + "\'" + color3 + "\'" + " ," + "\'" + color4 + "\'" + " ," + "\'" + tapecount + "\'" + " ," + "\'" + brushtype + "\'" + " ," + "\'" + comment + "\'" + ")";
                    System.out.println(sqlStatement);

                    Statement stmt = con.createStatement();
                    stmt.execute(sqlStatement);

                    JOptionPane.showMessageDialog(null, " Receipt" +
                        "\n Name : " + fullname +
                        "\n Email : " + email +
                        "\n Address : " + addy +
                        "\n State : " + state +
                        "\n Zip Code : " + zip +
                        "\n Paint Count : " + paintcount +
                        "\n Colors : " + color1 + " " + color2 + " " + color3 + " " + color4 +
                        "\n Tape Count : " + tapecount +
                        "\n Brush Type : " + brushtype +
                        "\n Order Comments : " + "'" + comment + "'");
                } catch (EntryException e) {
                    e.printStackTrace();
                }




               try {
                   File receipt = new File("receipt.txt");
                   FileWriter writer = new FileWriter(receipt);
                   writer.write(" Receipt " +
                        "\n Name : " + fullname +
                        "\n Email : " + email +
                        "\n Address : " + addy +
                        "\n State : " + state +
                        "\n Zip Code : " + zip +
                        "\n Paint Count : " + paintcount +
                        "\n Colors : " + color1 + " " + color2 + " " + color3 + " " + color4 +
                        "\n Tape Count : " + tapecount +
                        "\n Brush Type : " + brushtype +
                        "\n Order Comments : " + "'" + comment + "'");


                   writer.close();

               } catch (IOException e) {
                   e.printStackTrace();
               }


            } else if (event.getSource() == clearButton) {
                emailTextField.setText("");
                zipTextField.setText("");
                stateTextField.setText("");
                addyTextField.setText("");
                fullnameTextField.setText("");
                commentsArea.setText("");
                paintcolorCombo.setSelectedIndex(0);
                paintcolorCombo2.setSelectedIndex(0);
                paintcolorCombo3.setSelectedIndex(0);
                paintcolorCombo4.setSelectedIndex(0);
                tapeCombo.setSelectedIndex(0);
                paintpreBox.setSelected(false);
                paintpreBox2.setSelected(false);
                paintpreBox3.setSelected(false);
                paintpreBox4.setSelected(false);
                brushGroup.clearSelection();
                JOptionPane.showMessageDialog(null, "Entries have been cleared");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//------------End of Action Listener------------------------------------------------------------------------



    public static void main(String[] args) {
        Paintroom app = new Paintroom();


    }
}
