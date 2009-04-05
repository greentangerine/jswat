/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is JSwat. The Initial Developer of the Original
 * Software is Nathan L. Fiedler. Portions created by Nathan L. Fiedler
 * are Copyright (C) 2006-2009. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id$
 */

package com.bluemarsh.jswat.ui.views;

import com.sun.jdi.Location;
import org.apache.bcel.classfile.Code;
import java.util.Arrays;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 * Displays the byte codes of the current method.
 *
 * @author  Nathan Fiedler
 */
public class ByteCodesPanel extends javax.swing.JPanel {
    /** silence compiler warnings */
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form ByteCodesPanel.
     */
    public ByteCodesPanel() {
        initComponents();
    }

    /**
     * Clears the display area and file field, showing the error message
     * in the text field.
     *
     * @param  msg  the error message.
     */
    public void displayError(String msg) {
        hideLocation();
        fileTextField.setText(msg);
    }

    /**
     * Clear the display to hide any location information.
     */
    public void hideLocation() {
        differLabel.setEnabled(false);
        fileTextField.setText("");
        signatureTextField.setText("");
    }

    /**
     * Show the location information for the byte codes. Use the file to
     * show where the byte codes came from. Likewise, use the location to
     * determine if the codes match with the method in the debuggee, and
     * give an indication if not.
     *
     * @param  file      file from which byte codes were read.
     * @param  code      the byte codes to be displayed.
     * @param  location  the Location being displayed.
     */
    public void showLocation(FileObject file, Code code, Location location) {
        // Show where these byte codes came from.
//            FileObject jar = FileUtil.getArchiveFile(file);
//            StringBuilder path = new StringBuilder();
//            if (jar != null) {
//                // File was actually inside an archive.
//                path.append(jar.getNameExt());
//                path.append("!");
//            }
//            path.append(file.getNameExt());
//            fileLabel.setText(path.toString());
        String name = FileUtil.getFileDisplayName(file);
        fileTextField.setText(name);

        // Show the method signature since that is what the byte code
        // interpreter will show in the view.
        StringBuilder sign = new StringBuilder();
        sign.append(location.declaringType().name());
        sign.append('.');
        sign.append(location.method().name());
        sign.append(location.method().signature());
        signatureTextField.setText(sign.toString());

        // Indicate if the byte codes match the debuggee version.
        if (Arrays.equals(code.getCode(), location.method().bytecodes())) {
            differLabel.setEnabled(false);
        } else {
            differLabel.setEnabled(true);
        }
        // XXX: widgets do not update
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileLabel = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        differLabel = new javax.swing.JLabel();
        signatureLabel = new javax.swing.JLabel();
        signatureTextField = new javax.swing.JTextField();

        fileLabel.setLabelFor(fileTextField);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/bluemarsh/jswat/ui/views/Forms"); // NOI18N
        fileLabel.setText(bundle.getString("LBL_ByteCodes_File")); // NOI18N

        fileTextField.setEditable(false);
        fileTextField.setToolTipText(bundle.getString("HINT_ByteCodes_FileLabel")); // NOI18N

        differLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bluemarsh/jswat/views/resources/warning.gif"))); // NOI18N
        differLabel.setToolTipText(bundle.getString("HINT_ByteCodes_Differ")); // NOI18N
        differLabel.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bluemarsh/jswat/views/resources/empty.gif"))); // NOI18N
        differLabel.setEnabled(false);

        signatureLabel.setLabelFor(signatureTextField);
        signatureLabel.setText(bundle.getString("LBL_ByteCodes_Signature")); // NOI18N

        signatureTextField.setEditable(false);
        signatureTextField.setToolTipText(bundle.getString("HINT_ByteCodes_SignatureField")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileLabel)
                    .addComponent(signatureLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signatureTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fileTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(differLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileLabel)
                            .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(signatureLabel)
                            .addComponent(signatureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(differLabel)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel differLabel;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JLabel signatureLabel;
    private javax.swing.JTextField signatureTextField;
    // End of variables declaration//GEN-END:variables
}
