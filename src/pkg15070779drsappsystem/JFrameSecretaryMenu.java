package pkg15070779drsappsystem;
import java.awt.*;
import javax.swing.*;
//
public class JFrameSecretaryMenu extends JFrame {
    JDesktopPane desktop;
    //singleton DP, only one instance is ever needed
    private static JFrameSecretaryMenu SecMenuSingInst;
    
    //holds the string to tell the menu which south border to display
    private static String currentSouthBordPanel; 
    
    private JFrameSecretaryMenu(){
        super ("Secretary menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar secMenBar = new JMenuBar();
        setJMenuBar(secMenBar);
        
        JMenu fileMenu = new JMenu("File");
        secMenBar.add(fileMenu);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        
        JMenu appsMenu = new JMenu("Appointments");
        secMenBar.add(appsMenu);
        
        JMenuItem newApp = new JMenuItem ("New Appointment");
        //exitItem.addActionListener(new ExitListener ()); 
        appsMenu.add(newApp);
        
        JMenu patientMenu = new JMenu("Patients");
        secMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        //exitItem.addActionListener(new ExitListener ()); 
        patientMenu.add(findPatient);
        
        JMenu reportMenu = new JMenu("Reports");
        secMenBar.add(reportMenu);
        
        JMenuItem runReportAppsPerDoc = new JMenuItem ("Monthly App. per Dr");
        runReportAppsPerDoc.addActionListener(new ActListRunReport("MonthAppPerDr")); 
        reportMenu.add(runReportAppsPerDoc);
        
        JMenuItem runReportAppsAtt = new JMenuItem ("App. attendence");
        runReportAppsAtt.addActionListener(new ActListRunReport("MonthlyApssAtt")); 
        reportMenu.add(runReportAppsAtt);
        
        JMenuItem runReport = new JMenuItem ("Prescriptions");
        //exitItem.addActionListener(new ExitListener ()); 
        reportMenu.add(runReport);        
                
        setLayout (new BorderLayout ());
        
         //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        
    }
 
    //singleton design pattern as was struggling working with the instance created in
    //the AAAmain class
    public static JFrameSecretaryMenu getInstance(){
        if (SecMenuSingInst == null){
            SecMenuSingInst = new JFrameSecretaryMenu();
        }
        return SecMenuSingInst;
    }
    
    
    public void setSouthBorderString(String paneltoset){
        currentSouthBordPanel = paneltoset;
        SecMenuSingInst.setSouthBorderPanel();
    }
    
    private void setSouthBorderPanel(){
         //@@@@@@@@@@ all this needs to be done dynamically, create the objects when they are called (factory design pattern I think)
        if (currentSouthBordPanel == "MonthlyApssAtt"){
            JPanelReportsAppAtt JPanelAppsAtt = JPanelReportsAppAtt.getInstance();
            JPanelAppsAtt.setVisible(true);
            SecMenuSingInst.add(JPanelAppsAtt, BorderLayout.SOUTH);
            refreshJFrame();
           System.out.println("monthly apps called");
        }
        
        
        if (currentSouthBordPanel == "MonthAppPerDr"){
            JPanelReportsDrsApps JPanelDrsApps = JPanelReportsDrsApps.getInstance();
            //setLayout (new BorderLayout ());
            SecMenuSingInst.add(JPanelDrsApps, BorderLayout.SOUTH);
            refreshJFrame();
            System.out.println("drs called");
        }
        
        //JPanelDrsApps.setVisible(true);
        
      
    }
    
    public void refreshJFrame(){
         //these have to be called otherwise the Jframe doesn't refresh and
         //the menu doesn't display
            revalidate();
            repaint();
            
    }
    
      
    
}
