package Gui;

import Gui.setTheta;
import Gui.ClassForm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import main.Classes;
import main.IntegrationTesting;
import main.Method;
import main.Parameter;
import main.UnitTesting;

public class Workspace extends javax.swing.JPanel {

     private void ParseFile(){
        Classes currentClass = null;
        Method currentMethod = null;
        String currentParameter = null, currentType = null;
        Float currentMin = null;
        String s;
        Scanner scan = new Scanner(file);
        
        while(scan.hasNextLine()){
            s = scan.next();
            if( "<ClassName>".equals(s)){
                s = scan.next();
                currentClass = new Classes(s);
                classesList.add( currentClass );
            }
            else if( "<Dependency>".equals(s) ){
                s = scan.next();
                currentClass.addDependency(s);
            }
            else if( "<MethodName>".equals(s)){
                s = scan.next();
                currentMethod = currentClass.addMethod(s);
            }
            else if( "<ParameterName>".equals(s)){
                s = scan.next();
                currentParameter = s;
            }
            else if( "<Type>".equals(s)){
                s = scan.next();
                currentType = s;
            }
            else if( "<DomainMin>".equals(s)){
                s = scan.next();
                currentMin = Float.parseFloat(s);
            }
            else if( "<DomainMax>".equals(s)){
                s = scan.next();
                currentMethod.addParameter(currentParameter, currentMin, Float.parseFloat(s),currentType);
            }
            else {
                scan.nextLine();
            }
            
        }

    }
    
    
    public Workspace(String path) throws FileNotFoundException {
        listModel = new DefaultListModel();
        file = new FileReader(path);
        classesList = new LinkedList<Classes>();
        initComponents();
        ParseFile();
        UnitGroup = new ButtonGroup();
        UnitGroup.add(BvaButton);
        UnitGroup.add(RtButton);
        UnitTestingMethod = 0;
        IntegrationGroup = new ButtonGroup();
        IntegrationGroup.add(btButton);
        IntegrationGroup.add(ntButton);
        IntegrationGroup.add(ttButton);
        IntegrationGroup.add(ptButton);
        IntegrationTestingMethod = 0;
        flag = false;

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        workspace = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        unitPane = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        unitTextArea = new javax.swing.JTextArea();
        BvaButton = new javax.swing.JRadioButton();
        RtButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        GenerateButton = new javax.swing.JButton();
        saveToJavaButton = new javax.swing.JButton();
        integrationPane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btButton = new javax.swing.JRadioButton();
        ttButton = new javax.swing.JRadioButton();
        ptButton = new javax.swing.JRadioButton();
        ntButton = new javax.swing.JRadioButton();
        runButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        integrationTextArea = new javax.swing.JTextArea();
        ViewClasses = new javax.swing.JButton();
        addClass = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList(listModel);
        deleteClass = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();

        unitTextArea.setColumns(20);
        unitTextArea.setRows(5);
        jScrollPane8.setViewportView(unitTextArea);

        BvaButton.setText("BVA");
        BvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BvaButtonActionPerformed(evt);
            }
        });

        RtButton.setText("RT");
        RtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RtButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Method");

        GenerateButton.setText("Generate");
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });

        saveToJavaButton.setText("Save to Java");
        saveToJavaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToJavaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout unitPaneLayout = new javax.swing.GroupLayout(unitPane);
        unitPane.setLayout(unitPaneLayout);
        unitPaneLayout.setHorizontalGroup(
            unitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unitPaneLayout.createSequentialGroup()
                .addGroup(unitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(unitPaneLayout.createSequentialGroup()
                        .addGroup(unitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BvaButton)
                            .addComponent(RtButton)
                            .addGroup(unitPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(unitPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(unitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GenerateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(saveToJavaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        unitPaneLayout.setVerticalGroup(
            unitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
            .addGroup(unitPaneLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BvaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RtButton)
                .addGap(18, 18, 18)
                .addComponent(GenerateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveToJavaButton)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Unit Testing", unitPane);

        jLabel8.setText("Method");

        btButton.setText("BT");
        btButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btButtonActionPerformed(evt);
            }
        });

        ttButton.setText("TT");
        ttButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttButtonActionPerformed(evt);
            }
        });

        ptButton.setText("PT");
        ptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptButtonActionPerformed(evt);
            }
        });

        ntButton.setText("NT");
        ntButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntButtonActionPerformed(evt);
            }
        });

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        integrationTextArea.setColumns(20);
        integrationTextArea.setRows(5);
        jScrollPane1.setViewportView(integrationTextArea);

        javax.swing.GroupLayout integrationPaneLayout = new javax.swing.GroupLayout(integrationPane);
        integrationPane.setLayout(integrationPaneLayout);
        integrationPaneLayout.setHorizontalGroup(
            integrationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(integrationPaneLayout.createSequentialGroup()
                .addGroup(integrationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ptButton)
                    .addComponent(ntButton)
                    .addComponent(btButton)
                    .addComponent(ttButton)
                    .addGroup(integrationPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(integrationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        integrationPaneLayout.setVerticalGroup(
            integrationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(integrationPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ttButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ptButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ntButton)
                .addGap(18, 18, 18)
                .addComponent(runButton)
                .addContainerGap(177, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        tabbedPane.addTab("Integration Testing", integrationPane);

        ViewClasses.setText("View Classes");
        ViewClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewClassesActionPerformed(evt);
            }
        });

        addClass.setText("Add Class");
        addClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(list);

        deleteClass.setText("Delete Class");
        deleteClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClassActionPerformed(evt);
            }
        });

        infoButton.setText("View Info");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout workspaceLayout = new javax.swing.GroupLayout(workspace);
        workspace.setLayout(workspaceLayout);
        workspaceLayout.setHorizontalGroup(
            workspaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workspaceLayout.createSequentialGroup()
                .addGroup(workspaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ViewClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        workspaceLayout.setVerticalGroup(
            workspaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workspaceLayout.createSequentialGroup()
                .addGroup(workspaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(workspaceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(workspaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(workspaceLayout.createSequentialGroup()
                                .addComponent(ViewClasses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addClass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteClass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoButton)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(workspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(workspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ViewClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewClassesActionPerformed
       if(list.getModel().getSize() == 0) {
            for(int i = 0; i < classesList.size(); i++) {
                listModel.addElement(classesList.get(i).getClassName());
        }
        }
    }//GEN-LAST:event_ViewClassesActionPerformed

    private void deleteClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClassActionPerformed
        int i = list.getSelectedIndex();
        classesList.remove(i);
        listModel.remove(i);
    }//GEN-LAST:event_deleteClassActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));  
       int returnVal = fc.showSaveDialog(null); 
       if(returnVal == JFileChooser.APPROVE_OPTION){
           File outfile = new File(fc.getSelectedFile() + ".xml");
           BufferedWriter outStream = null;
            try {
                outStream =  new BufferedWriter(new FileWriter( outfile));
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outStream.write("<System>\n");
                outStream.write("  <SystemName> Generated XML File </SystemName>\n");
                outStream.write("  <Classes>\n");
                for(int i = 0; i < classesList.size(); i++){
                    outStream.write("\t<Class>\n");
                    outStream.write("\t<ClassName> " + classesList.get(i).getClassName() + " </ClassName>\n");
                    outStream.write("\t<Methods>\n");
                    List<Method> m = classesList.get(i).getMethodList();
                    for(int j = 0; j < m.size(); j++){
                        outStream.write("\t  <Method>\n");
                        outStream.write("\t   <MethodName> " + m.get(j).getMethodName() + " </MethodName>\n");
                        List<Parameter> par = m.get(j).getParameterList();
                        outStream.write("\t   <Parameters>\n");
                        for(int k = 0; k < par.size(); k++){
                            outStream.write("\t  <Parameter>\n");
                            outStream.write("\t\t<ParameterName> " + par.get(k).getParameterName() + " </ParameterName>\n");
                            outStream.write("\t\t<Type> " + par.get(k).getType() + " </Type>\n");
                            outStream.write("\t\t<DomainMin> " + par.get(k).getParameterMin().toString() + " </DomainMin>\n");
                            outStream.write("\t\t<DomainMax> " + par.get(k).getParameterMax().toString() + " </DomainMax>\n");  
                            outStream.write("\t  </Parameter>\n");
                        }
                        outStream.write("\t  </Method>\n");
                   }
                   List<String> dep = classesList.get(i).getDependencyList();
                   outStream.write("\t  <Dependencies>\n");
                   for(int j = 0; j < dep.size(); j++) {
                        outStream.write("\t\t<Depencency> " + dep.get(j) + " </Dependency>\n");
                    }
                    outStream.write("\t  </Dependencies>\n");
                    
                }
                outStream.write("  </Classes>\n");
                outStream.write("</System>\n");
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
        unitTextArea.setText("");
        if(UnitTestingMethod != 0){
            UnitTesting test = new UnitTesting(classesList.get(list.getSelectedIndex()), UnitTestingMethod, unitTextArea);
            test.run();
        }
    }//GEN-LAST:event_GenerateButtonActionPerformed

    private void BvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BvaButtonActionPerformed
        UnitTestingMethod = 1;
    }//GEN-LAST:event_BvaButtonActionPerformed

    private void RtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RtButtonActionPerformed
        UnitTestingMethod = 2;
    }//GEN-LAST:event_RtButtonActionPerformed

    private void saveToJavaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToJavaButtonActionPerformed
       JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));  
       int returnVal = fc.showSaveDialog(null); 
       if(returnVal == JFileChooser.APPROVE_OPTION){
           File outfile = new File(fc.getSelectedFile() + ".java");
           BufferedWriter outStream = null;
            try {
                outStream =  new BufferedWriter(new FileWriter( outfile));
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outStream.write(unitTextArea.getText());
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_saveToJavaButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
         if(list.getModel().getSize() != 0){
            JFrame frame = new JFrame();
            JTextArea ta = new JTextArea();
            ta.setEditable(false);
            ta.setSize(400,300);
            frame.add(ta);
            frame.setSize(400,300);
            frame.setVisible(true);

             Classes s = classesList.get(list.getSelectedIndex());
             ta.append("Class Name: " + s.getClassName() + "\n");
             List<Method> l = s.getMethodList();
             List<String> dep = s.getDependencyList();
             for(int i = 0; i < dep.size(); i++){
                 ta.append("\tDependency: " + dep.get(i) + "\n");
             }
                 
             for( int i = 0; i < l.size(); i++){
                Method m = l.get(i);
                ta.append("\tMethod name: " + m.getMethodName() + "\n");
                List<Parameter> p = m.getParameterList();
                for( int j = 0; j < p.size(); j++){
                    Parameter par = p.get(j);
                    ta.append("\t\tParameter : " + par.getType() + " " + par.getParameterName() + "(" + par.getParameterMin() + " , "+ par.getParameterMax() +")\n");
                }
             }
        }

    }//GEN-LAST:event_infoButtonActionPerformed


    
    private void addClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassActionPerformed
        Classes newClass;
        ClassForm c = new ClassForm(listModel, classesList);
        c.setVisible(true);
    }//GEN-LAST:event_addClassActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        integrationTextArea.setText("");
        IntegrationTesting intTest = new IntegrationTesting(classesList, IntegrationTestingMethod, integrationTextArea);
        intTest.run();
    }//GEN-LAST:event_runButtonActionPerformed

    private void ntButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntButtonActionPerformed
        IntegrationTestingMethod = 4;
    }//GEN-LAST:event_ntButtonActionPerformed

    private void ptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptButtonActionPerformed
        IntegrationTestingMethod = 3;
    }//GEN-LAST:event_ptButtonActionPerformed

    private void ttButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttButtonActionPerformed
        IntegrationTestingMethod = 2;
    }//GEN-LAST:event_ttButtonActionPerformed

    private void btButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btButtonActionPerformed
        IntegrationTestingMethod = 1;
    }//GEN-LAST:event_btButtonActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged

    }//GEN-LAST:event_listValueChanged

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if(evt.getClickCount() == 2) {
            Classes s = classesList.get(list.getSelectedIndex());
            List<Method> l = s.getMethodList();
            for( int i = 0; i < l.size(); i++){
                Method m = l.get(i);
                List<Parameter> p = m.getParameterList();
                for( int j = 0; j < p.size(); j++){
                    Parameter par = p.get(j);
                    setTheta x = new setTheta(par);
                    x.setValues(m.getMethodName(),par.getParameterName(), par.getParameterMin(), par.getParameterMax());

                }
            }
        }
    }//GEN-LAST:event_listMouseClicked
    private boolean flag;
    private int UnitTestingMethod;
    private int IntegrationTestingMethod;
    private DefaultListModel listModel;
    private FileReader file;
    private List<Classes> classesList;
    private ButtonGroup UnitGroup;
    private ButtonGroup IntegrationGroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BvaButton;
    private javax.swing.JButton GenerateButton;
    private javax.swing.JRadioButton RtButton;
    private javax.swing.JButton ViewClasses;
    private javax.swing.JButton addClass;
    private javax.swing.JRadioButton btButton;
    private javax.swing.JButton deleteClass;
    private javax.swing.JButton infoButton;
    private javax.swing.JPanel integrationPane;
    private javax.swing.JTextArea integrationTextArea;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList list;
    private javax.swing.JRadioButton ntButton;
    private javax.swing.JRadioButton ptButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveToJavaButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JRadioButton ttButton;
    private javax.swing.JPanel unitPane;
    private javax.swing.JTextArea unitTextArea;
    private javax.swing.JPanel workspace;
    // End of variables declaration//GEN-END:variables
}
