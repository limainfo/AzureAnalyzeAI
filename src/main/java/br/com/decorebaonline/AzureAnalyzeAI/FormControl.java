package br.com.decorebaonline.AzureAnalyzeAI;

import com.azure.ai.documentintelligence.DocumentIntelligenceClient;
import com.azure.ai.documentintelligence.DocumentIntelligenceClientBuilder;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.views.DocumentViewController;
import org.icepdf.ri.common.views.DocumentViewControllerImpl;
import com.azure.ai.documentintelligence.models.AnalyzeDocumentRequest;
import com.azure.ai.documentintelligence.models.AnalyzeResult;
import com.azure.ai.documentintelligence.models.Document;
import com.azure.ai.documentintelligence.models.DocumentField;
import com.azure.ai.documentintelligence.models.DocumentKeyValuePair;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.util.BinaryData;
import com.azure.core.util.polling.SyncPoller;
import java.awt.Cursor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author limainfo@gmail.com
 */
public class FormControl extends javax.swing.JFrame {

    private static final String endpoint = "<YOUR ENDPOINT>";
    private static final String key = "<YOUR KEY>";
    private SwingController controller;
    private JPanel viewerComponentPanel;
    private Integer Rows = 0;

    public FormControl() {
        initComponents();
        initPDFViewer();
         pack();
        setLocationRelativeTo(null);
    }

    private void initPDFViewer() {
        controller = new SwingController();
        DocumentViewController viewController = new DocumentViewControllerImpl(controller);
        controller.setDocumentViewController((DocumentViewControllerImpl) viewController);
        Container documentViewPanel = controller.getDocumentViewController().getViewContainer();
        Dimension preferredSize = jPanelPdf.getSize();
        documentViewPanel.setPreferredSize(preferredSize);
        jPanelPdf.setLayout(new BorderLayout());
        jPanelPdf.add(documentViewPanel, BorderLayout.CENTER);
        jPanelPdf.revalidate();
        jPanelPdf.repaint();
        jPanelPdf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newSize = jPanelPdf.getSize();
                documentViewPanel.setPreferredSize(newSize);
                documentViewPanel.revalidate();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserPdf = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelSuporte = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelButtonLoad = new javax.swing.JPanel();
        jTextFieldPath = new javax.swing.JTextField();
        jButtonLoad = new javax.swing.JButton();
        jPanelPdf = new javax.swing.JPanel();
        jButtonAnalyze = new javax.swing.JButton();
        jScroolPaneTable = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(900, 800));

        jPanelSuporte.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSuporte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jPanelTitulo.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Analyze Pdf Document");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTextFieldPath.setText("C:\\Users\\User\\Documents\\teste.pdf");
        jTextFieldPath.setEnabled(false);

        jButtonLoad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLoad.setText("Load PDF");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonLoadLayout = new javax.swing.GroupLayout(jPanelButtonLoad);
        jPanelButtonLoad.setLayout(jPanelButtonLoadLayout);
        jPanelButtonLoadLayout.setHorizontalGroup(
            jPanelButtonLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonLoadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelButtonLoadLayout.setVerticalGroup(
            jPanelButtonLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonLoadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(jButtonLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelPdf.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPdf.setForeground(new java.awt.Color(255, 255, 255));
        jPanelPdf.setName("JPanelPdf"); // NOI18N

        javax.swing.GroupLayout jPanelPdfLayout = new javax.swing.GroupLayout(jPanelPdf);
        jPanelPdf.setLayout(jPanelPdfLayout);
        jPanelPdfLayout.setHorizontalGroup(
            jPanelPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelPdfLayout.setVerticalGroup(
            jPanelPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        jButtonAnalyze.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAnalyze.setText("Analyze");
        jButtonAnalyze.setEnabled(false);
        jButtonAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalyzeActionPerformed(evt);
            }
        });

        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pagador", "DataPagamento", "ContaSaida", "Beneficiário", "CpfCnpjBeneficiário", "ValorPago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableResult.setName("jTableResult"); // NOI18N
        jScroolPaneTable.setViewportView(jTableResult);

        javax.swing.GroupLayout jPanelSuporteLayout = new javax.swing.GroupLayout(jPanelSuporte);
        jPanelSuporte.setLayout(jPanelSuporteLayout);
        jPanelSuporteLayout.setHorizontalGroup(
            jPanelSuporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelSuporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSuporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelButtonLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScroolPaneTable))
                .addContainerGap())
            .addComponent(jButtonAnalyze, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSuporteLayout.setVerticalGroup(
            jPanelSuporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuporteLayout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScroolPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSuporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSuporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalyzeActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jButtonAnalyze.setEnabled(false);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() throws Exception {
                DocumentIntelligenceClient client = new DocumentIntelligenceClientBuilder()
                        .credential(new AzureKeyCredential(key))
                        .endpoint(endpoint)
                        .buildClient();

                String modelId = "evaldo-training";
                String documentUrl = "https://raw.githubusercontent.com/limainfo/AzureAnalyzeAI/refs/heads/main/teste.pdf";

                try {
                    String pdfPath = jTextFieldPath.getText();
                    byte[] pdfBytes = Files.readAllBytes(Paths.get(pdfPath));

                    AnalyzeDocumentRequest analyzeRequest = new AnalyzeDocumentRequest().setBase64Source(pdfBytes);

                    // Converter o AnalyzeDocumentRequest em BinaryData
                    BinaryData requestBody = BinaryData.fromObject(analyzeRequest);

                    // Criar RequestOptions e definir o corpo da solicitação
                    RequestOptions requestOptions = new RequestOptions()
                            .setBody(requestBody)
                            .addHeader("Content-Type", "application/json");

                    // Iniciar a análise do documento
                    SyncPoller<BinaryData, BinaryData> analyzeDocumentPoller
                            = client.beginAnalyzeDocument(modelId, requestOptions);

                    // Aguardar a conclusão da análise
                    analyzeDocumentPoller.waitForCompletion();

                    // Obter o resultado final
                    BinaryData analyzeResultData = analyzeDocumentPoller.getFinalResult();

                    // Converter o resultado em AnalyzeResult
                    AnalyzeResult analyzeResult = analyzeResultData.toObject(AnalyzeResult.class);
                    List<Document> documents = analyzeResult.getDocuments();

                    // Verificar se a lista de documentos não é nula ou vazia
                    if (documents != null && !documents.isEmpty()) {
                        for (Document document : documents) {
                            System.out.println("Tipo de Documento: " + document.getDocType());
                            Map<String, DocumentField> fields = document.getFields();

                            if (fields != null && !fields.isEmpty()) {
                                for (Map.Entry<String, DocumentField> fieldEntry : fields.entrySet()) {
                                    String fieldName = fieldEntry.getKey();
                                    DocumentField fieldValue = fieldEntry.getValue();
                                    String content = fieldValue.getContent();
                                    switch (fieldName) {
                                        case "Pagador":
                                            jTableResult.setValueAt(content, Rows, 0);
                                            break;
                                        case "DataPagamento":
                                            jTableResult.setValueAt(content, Rows, 1);
                                            break;
                                        case "ContaSaida":
                                            jTableResult.setValueAt(content, Rows, 2);
                                            break;
                                        case "Beneficiario":
                                            jTableResult.setValueAt(content, Rows, 3);
                                            break;
                                        case "CpfCnpjBeneficiario":
                                            jTableResult.setValueAt(content, Rows, 4);
                                            break;
                                        case "ValorPago":
                                            jTableResult.setValueAt(content, Rows, 5);
                                            break;

                                    }
                                }
                                Rows = Rows + 1;

                            } else {
                                JOptionPane.showMessageDialog(FormControl.this, "Nenhum campo encontrado neste documento.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(FormControl.this, "Nenhum documento analisado encontrado.");
                        
                    }

                } catch (IOException ex) {
                    Logger.getLogger(FormControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }

            @Override
            protected void done() {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(FormControl.this, "Análise concluída!");
            }
        };
        worker.execute();
    }//GEN-LAST:event_jButtonAnalyzeActionPerformed

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed
        // TODO add your handling code here:
        // Definir o filtro para arquivos PDF
        jFileChooserPdf.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true; // Mostrar diretórios
                } else {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".pdf");
                }
            }

            public String getDescription() {
                return "Arquivos PDF (*.pdf)";
            }
        });
        if (jFileChooserPdf.showOpenDialog(jPanelPdf) == JFileChooser.APPROVE_OPTION) {
            jTextFieldPath.setText(jFileChooserPdf.getSelectedFile().toString());
            String pdfPath = jTextFieldPath.getText();

            // Verificar se o campo de texto não está vazio
            if (pdfPath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, insira o caminho do arquivo PDF.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                File pdfFile = new File(pdfPath);
                if (!pdfFile.exists()) {
                    throw new FileNotFoundException("Arquivo não encontrado: " + pdfPath);
                }

                // Abrir o documento PDF usando o caminho do arquivo        
                controller.openDocument(pdfFile.getAbsolutePath());
                controller.setPageFitMode(controller.getDocumentViewController().PAGE_FIT_NONE, false);
                jButtonAnalyze.setEnabled(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar o PDF: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonLoadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalyze;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooserPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelButtonLoad;
    private javax.swing.JPanel jPanelPdf;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelSuporte;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScroolPaneTable;
    private javax.swing.JTable jTableResult;
    private javax.swing.JTextField jTextFieldPath;
    // End of variables declaration//GEN-END:variables

}
