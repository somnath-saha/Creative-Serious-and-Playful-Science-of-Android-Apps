import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This applet is a simple demo of using a JLabel, some JSliders, and a JComboBox 
 * and laying them out in a GridLayout.  This class contains a main() routine,
 * so that it can also be run as a stand-alone application.
 *  */
public class SliderAndComboBoxDemo extends JApplet {

   /**
    * The main() routine simply opens a window that shows a panel of type
    * ContentPanel, where ContentPanel is a nested class that does all the
    * work of the program.  Note that the main() routine uses the pack()
    * method of the JFrame, so that the size of the ContentPanel will be
    * equal to its preferred size.
    */
   public static void main(String[] args) {
      JFrame window = new JFrame("Layout Demo");
      ContentPanel content = new ContentPanel();
      window.setContentPane(content);
      window.pack();
      window.setLocation(100,100);
      window.setResizable(false);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);
   }
   
   /**
    * The init() method of the applet simply uses a panel of type
    * ContentPanel as the content pane of the applet.
    */
   public void init() {
      setContentPane( new ContentPanel() );
   }
   
    /**
     * This nested class defines the JPanel that holds the four components:
     * a label that displays the message "Hello  World", a combo box that
     * lets the user choose the style of the font in the label, a slider
     * that changes the background color of the label, and another slider
     * that changes the foreground color of the label.
     */
   public static class ContentPanel extends JPanel
                     implements ActionListener, ChangeListener{
      
      private JLabel displayLabel;        // Components that will be 
      private JComboBox fontStyleSelect;  //          displayed in this panel.
      private JSlider bgColorSlider, fgColorSlider;
      
      /**
       * The constructor creates components, sets up listening, and adds
       * the components to the panel.
       */
      public ContentPanel() {
         
         /* Create the sliders, and set up the panel to listen for
            ChangeEvents that are generated by the sliders. */
         
         bgColorSlider = new JSlider(0,255,100);
         bgColorSlider.addChangeListener(this);
         
         fgColorSlider = new JSlider(0,255,200);
         fgColorSlider.addChangeListener(this);

         /* Create the combo box, and add four items to it listing
            different font styles.  Set up the panel to listen for
            ActionEvents from the combo box. */

         fontStyleSelect = new JComboBox();
         fontStyleSelect.addItem("Plain Font");
         fontStyleSelect.addItem("Italic Font");
         fontStyleSelect.addItem("Bold Font");
         fontStyleSelect.addItem("Bold Italic Font");
         fontStyleSelect.setSelectedIndex(2);
         fontStyleSelect.addActionListener(this);
         
         /* Create the display label, with properties to match the
            values of the sliders and the setting of the combo box. */
         
         displayLabel = new JLabel("Hello World!", JLabel.CENTER);
         displayLabel.setOpaque(true);
         displayLabel.setBackground( new Color(100,100,100) );
         displayLabel.setForeground( new Color(255, 200, 200) );
         displayLabel.setFont( new Font("Serif", Font.BOLD, 30) );
         
         /* Set the layout for the panel, and add the four components. 
            Use a GridLayout with 4 rows and 1 columns. */
         
         setLayout(new GridLayout(4,1));
         add(displayLabel);
         add(bgColorSlider);
         add(fgColorSlider);
         add(fontStyleSelect);
         
      } // end constructor

      /**
       * This method will be called when the user changes the selection
       * in the combo box.  The method just changes the label's font to
       * match the new selection.
       */
      public void actionPerformed(ActionEvent evt) {
         switch ( fontStyleSelect.getSelectedIndex() ) {
         case 0:
            displayLabel.setFont( new Font("Serif", Font.PLAIN, 30) );
            break;
         case 1:
            displayLabel.setFont( new Font("Serif", Font.ITALIC, 30) );
            break;
         case 2:
            displayLabel.setFont( new Font("Serif", Font.BOLD, 30) );
            break;
         case 3:
            displayLabel.setFont( new Font("Serif", Font.BOLD + Font.ITALIC, 30) );
            break;
         }
      }

      /**
       * This method is called when the value is changed on either of the
       * sliders.  It sets the foreground or background color of the label
       * to match the value on the slider that has changed. 
       */
      public void stateChanged(ChangeEvent evt) {
         if (evt.getSource() == bgColorSlider) {
            int bgVal = bgColorSlider.getValue();
            displayLabel.setBackground( new Color(bgVal,bgVal,bgVal) );
               // NOTE:  The background color is a shade of gray,
               //        determined by the setting on the slider.
         }
         else {
            int fgVal = fgColorSlider.getValue();
            displayLabel.setForeground( new Color( 255, fgVal, fgVal) );
               // Note:  The foreground color ranges from pure red to pure
               //        white as the slider value increases from 0 to 255.
         }
      }

   } // end nested class ContentPanel
   
} // end class SliderAndComboBoxDemo

