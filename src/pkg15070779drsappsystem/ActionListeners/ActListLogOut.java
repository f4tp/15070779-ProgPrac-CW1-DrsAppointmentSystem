package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import pkg15070779drsappsystem.JFrames.JFramePatientMenu;
import pkg15070779drsappsystem.JFrames.JFramePharmacistMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForDoctor;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient;
import pkg15070779drsappsystem.JPanels.JPanelLoginScreen;
import pkg15070779drsappsystem.JPanels.JPanelNewAppButPan;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.JPanels.JPanelPatientAddDoctor;
import pkg15070779drsappsystem.JPanels.JPanelReportsAppAtt;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPanelReportsPresrcips;
import pkg15070779drsappsystem.JPanels.JPanelSecretaryFindPat;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaPrintPatRec;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainPrescription;
import pkg15070779drsappsystem.MainClasses.MainSecretary;

public class ActListLogOut implements ActionListener {
    
    public ActListLogOut(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //set all static global users and people objetcs that were being worked on to null
        
        MainAbsSystemUserComponent.currentSystemUser = null;
        MainPatient.currentPatient = null;
        MainAppointment.currentAppointment = null;
        MainDoctor.currentDoctor = null;
        MainSecretary.currentSecretary = null;
        MainPrescription currentPrescription = null;
        
      //set all JFrames to invisible
        JFrameSecretaryMenu instHolder = JFrameSecretaryMenu.getInstance();
        instHolder.setVisible(false);
        
        JFrameDoctorMenu instHolderr = JFrameDoctorMenu.getInstance();
        instHolderr.setVisible(false);
        
        JFramePatientMenu instHolderrr = JFramePatientMenu.getInstance();
        instHolderrr.setVisible(false);
        
        JPanelReportsAppAtt JPanelAppsAtt = JPanelReportsAppAtt.getInstance();
        JPanelAppsAtt.setVisible(false);
        JPanelReportsDrsApps JPanelDrsApps = JPanelReportsDrsApps.getInstance(); 
        JPanelDrsApps.setVisible(false);
        JPanelReportsPresrcips JPanelPrescs= JPanelReportsPresrcips.getInstance();
        JPanelPrescs.setVisible(false);
        JPanelSecretaryFindPat JPanelFindPat = JPanelSecretaryFindPat.getInstance();
       JPanelFindPat .setVisible(false);
        JPanelPatRecordSecView JPanelPatrecNorth = JPanelPatRecordSecView.getInstance();
        JPanelPatrecNorth.setVisible(false);
        //JPanelPatientRecButPanSEC JPanelPatrecSouth = JPartPanelPatRecButPanSEC.getInstance();
        JPanelPatientAddDoctor JPanelPatAddDoc = JPanelPatientAddDoctor.getInstance();
        JPanelPatAddDoc.setVisible(false);
        JPanelNewAppointment JPanNewApp = JPanelNewAppointment.getInstance();
        JPanNewApp.setVisible(false);
        JPanelNewAppButPan JPanNewAppButPanel = JPanelNewAppButPan.getInstance();
        JPanNewAppButPanel.setVisible(false);
        JPanelAppsShowAllForPatient JPanViewAllApps = JPanelAppsShowAllForPatient.getInstance();
       JPanViewAllApps .setVisible(false);
        JPanelAppsShowAllForDoctor JpanShowApps = JPanelAppsShowAllForDoctor.getInstance();
        JpanShowApps.setVisible(false);
        JPartPanelTextAreaMonthReports JPanTextFieldForReports = JPartPanelTextAreaMonthReports.getInstance();
        JPanTextFieldForReports.setVisible(false);
        JPanelAppAmendSecView JPanAmendApp = JPanelAppAmendSecView.getInstance();
        
        
        
        
        
        
        
        
        
        
            //clears the Jtextholder that updates with the patient's record details, when they logout
        JPartPanelTextAreaPrintPatRec refHolder = JPartPanelTextAreaPrintPatRec.getInstance();
        refHolder.setJtextArea("");
        
         //clears the Jtextholder that updates with the report details, when the sec logs out
        JPartPanelTextAreaMonthReports refHoldersec = JPartPanelTextAreaMonthReports.getInstance();
        refHoldersec.setJtextArea("");
        
        
        
        
     //set login screen back to visible
        JFrameLoginScreen loginInstance = JFrameLoginScreen.getInstance();
        loginInstance.setVisible(true);
        
        JPanelLoginScreen tempLoginJPan = JPanelLoginScreen.getInstance();
        tempLoginJPan.updateLogintext();
        
        
    
        
            
    }
    
   
    
    
    
}
