
package pkg15070779drsappsystem.JFrames;

import pkg15070779drsappsystem.ActionListeners.ActListSetSecJFramePARTofFACTORYsec;
import pkg15070779drsappsystem.ActionListeners.ActLisExitProg;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.ActionListeners.ActListDisplayFindPatDocView;
import pkg15070779drsappsystem.ActionListeners.ActListLogOut;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientDOC;
import pkg15070779drsappsystem.JPanels.JPanelPatFindDocView;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordDocView;
import static pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow.setDrComboBox;
import pkg15070779drsappsystem.MainClasses.MainPatient;


public class JFrameDoctorMenu extends JFrame {
    
     //singleton DP, only one instance is ever needed as only one sec logs in at once
    private static JFrameDoctorMenu DoctMenSingInst;
    MainPatient currPatientInst;
    
    
    //holds the string to tell the menu which south border to display
    private static String currentDocNorthBordPanel; 
    
    private JFrameDoctorMenu(){
        super ("Doctor's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar docMenBar = new JMenuBar();
        setJMenuBar(docMenBar);
        
        JMenu fileMenu = new JMenu("File");
        docMenBar.add(fileMenu);
        
         JMenuItem logOutItem = new JMenuItem ("Logout");
        //logOutItem.addActionListener(new ActLisExitProg ());
        logOutItem.addActionListener(new ActListLogOut());
        fileMenu.add(logOutItem);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        JMenu patientMenu = new JMenu("Patients");
        docMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        findPatient.addActionListener(new ActListDisplayFindPatDocView("FindPatients"));
        patientMenu.add(findPatient);
        
        //lays out the frame using thsi abstract class
        JFrameAbsBorLayFillScreen.applyLayout(this);
        /*
        setLayout (new BorderLayout ());
        
         //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        */
        
        
        
        
        
        
        
    }
    
    
    private void setDocNorthBorderPanel(){
        JPanelPatFindDocView JPanelFindPat = JPanelPatFindDocView.getInstance();
        JPanelPatRecordDocView jpanPatRecDocViewSingInst = JPanelPatRecordDocView.getInstance();
        //JPanelPatRecordDocView JPanelPatrecNorth = JPanelPatRecordDocView.getInstance();  
        JPanelAppsShowAllForPatientDOC JPanViewAllApps = JPanelAppsShowAllForPatientDOC.getInstance();
         JPanelAppAmendDocView JPanAmendApp = JPanelAppAmendDocView.getInstance();
                
        
          if (currentDocNorthBordPanel == "FindPatients"){
              jpanPatRecDocViewSingInst.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JPanAmendApp.setVisible(false);

              
              
             JPanelFindPat.setVisible(true); 
             DoctMenSingInst.add(JPanelFindPat, BorderLayout.NORTH);
            
            
            
          }
          
           if (currentDocNorthBordPanel == "DisplayPatientDetails"){
             JPanelFindPat.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JPanAmendApp.setVisible(false);
             
             
             jpanPatRecDocViewSingInst.setVisible(true);
             jpanPatRecDocViewSingInst.setUpdateTextFields(currPatientInst.getUserName());
            
            DoctMenSingInst.add(jpanPatRecDocViewSingInst, BorderLayout.NORTH);
          }
           
           
        
           if(currentDocNorthBordPanel == "DispPatientAppointments"){
               jpanPatRecDocViewSingInst.setVisible(false); 
               JPanelFindPat.setVisible(false);
               JPanAmendApp.setVisible(false);
               
            //JPanelPatrecNorth.setVisible(true);
            //JPanelPatrecNorth.setUpdateTextFields(currPatientInst.getUserName());
            //JPanelPatrecSouth.setVisible(true);
            //DoctMenSingInst.add(JPanelPatrecNorth, BorderLayout.NORTH);
            //SecMenuSingInst.add(JPanelPatrecSouth, BorderLayout.CENTER);
            
            JPanViewAllApps.setVisible(true);
            DoctMenSingInst.add(JPanViewAllApps, BorderLayout.NORTH);
               
           }
           
            if (currentDocNorthBordPanel == "ShowAmendApps"){
           JPanelFindPat.setVisible(false); 
            jpanPatRecDocViewSingInst.setVisible(false);
            JPanViewAllApps.setVisible(false);
           
           
           
            
            JPanAmendApp.setVisible(true);
            
            //updates the combobox on this form with Drs registered on the system (when it is called);
            //this form contains two instances of the same JPanel - dates from and to
            setDrComboBox();
            DoctMenSingInst.add(JPanAmendApp, BorderLayout.NORTH);
      
        }
          
          
        revalidate();
        repaint();
    }
    
    
    //get single instance so no other instances are created
    public static JFrameDoctorMenu getInstance(){
        if (DoctMenSingInst == null){
            DoctMenSingInst = new JFrameDoctorMenu();
                    }
        return DoctMenSingInst;
    }
    
    public void setVisibility(boolean vis){
        
        this.setVisible(vis);
        
    }
    
    public void setDocSouthBorderString(String paneltoset){
        currentDocNorthBordPanel = paneltoset;
        DoctMenSingInst.setDocNorthBorderPanel();
    }
    
    public void setDocSouthBorderString(String paneltoset, MainPatient patientinvolved){
        
        currentDocNorthBordPanel = paneltoset;
        currPatientInst = patientinvolved;
        DoctMenSingInst.setDocNorthBorderPanel();
    }
    
    
}
