package Frontera;

import Control.ValidarMenuP;
import DAO.MenuPDAO;
import Entidad.MenuP;

public class NuevoMenuP extends javax.swing.JPanel {

    private final MenuPDAO daoMenp = new MenuPDAO();
    private final MenuP menup = new MenuP();
    private final ValidarMenuP validar = new ValidarMenuP();

    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    private int filaU = 0;

    public NuevoMenuP() {
        initComponents();
    }

    public boolean validarCampos() {
        return (restauranteLabel.getText().isEmpty()
                && turnoLabel.getText().isEmpty());
    }

    public boolean validarComidas() {
        return (restauranteLabel.getText().isEmpty()
                && turnoLabel.getText().isEmpty());
    }

    public void vaciarCampos() {
        comPer.setSelectedIndex(0);
        mesaLabel.setText("");
        restauranteLabel.setText("");
        turnoLabel.setText("");
    }

    public void vaciarCom() {
        comEnt1.setText("");
        comEnt2.setText("");
        comEnt3.setText("");
        comEnt4.setText("");
        comEnt5.setText("");
        comEnt6.setText("");
        comEnt7.setText("");
        comPla1.setText("");
        comPla2.setText("");
        comPla3.setText("");
        comPla4.setText("");
        comPla5.setText("");
        comPla6.setText("");
        comPla7.setText("");
        comPos1.setText("");
        comPos2.setText("");
        comPos3.setText("");
        comPos4.setText("");
        comPos5.setText("");
        comPos6.setText("");
        comPos7.setText("");
        comCos1.setText("");
        comCos2.setText("");
        comCos3.setText("");
        comCos4.setText("");
        comCos5.setText("");
        comCos6.setText("");
        comCos7.setText("");
    }

    public void inhabilitarCom() {
        comEnt1.setEnabled(false);
        comEnt2.setEnabled(false);
        comEnt3.setEnabled(false);
        comEnt4.setEnabled(false);
        comEnt5.setEnabled(false);
        comEnt6.setEnabled(false);
        comEnt7.setEnabled(false);
        comPla1.setEnabled(false);
        comPla2.setEnabled(false);
        comPla3.setEnabled(false);
        comPla4.setEnabled(false);
        comPla5.setEnabled(false);
        comPla6.setEnabled(false);
        comPla7.setEnabled(false);
        comPos1.setEnabled(false);
        comPos2.setEnabled(false);
        comPos3.setEnabled(false);
        comPos4.setEnabled(false);
        comPos5.setEnabled(false);
        comPos6.setEnabled(false);
        comPos7.setEnabled(false);
        comCos1.setEnabled(false);
        comCos2.setEnabled(false);
        comCos3.setEnabled(false);
        comCos4.setEnabled(false);
        comCos5.setEnabled(false);
        comCos6.setEnabled(false);
        comCos7.setEnabled(false);
    }

    public void deseleccionarCom() {
        comEnt1.setSelected(false);
        comEnt2.setSelected(false);
        comEnt3.setSelected(false);
        comEnt4.setSelected(false);
        comEnt5.setSelected(false);
        comEnt6.setSelected(false);
        comEnt7.setSelected(false);
        comPla1.setSelected(false);
        comPla2.setSelected(false);
        comPla3.setSelected(false);
        comPla4.setSelected(false);
        comPla5.setSelected(false);
        comPla6.setSelected(false);
        comPla7.setSelected(false);
        comPos1.setSelected(false);
        comPos2.setSelected(false);
        comPos3.setSelected(false);
        comPos4.setSelected(false);
        comPos5.setSelected(false);
        comPos6.setSelected(false);
        comPos7.setSelected(false);
        comCos1.setSelected(false);
        comCos2.setSelected(false);
        comCos3.setSelected(false);
        comCos4.setSelected(false);
        comCos5.setSelected(false);
        comCos6.setSelected(false);
        comCos7.setSelected(false);
    }

    public void guardarDatos() {

        String respuesta;

        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            menup.setPersona(0);

            respuesta = validar.validarMenuP(menup);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            menup.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            menup.setMesa(mesaLabel.getText());
            menup.setTurno(turnoLabel.getText());
            if (entrada() || plato() || postre() || costo()) {
                entCom();
                plaCom();
                posCos();
                cosCom();

                respuesta = validar.validarMenuP(menup);

                if ("Longitud mesa incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else {
                    if (!validarComidas()) {
                        if ("Longitud persona incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud entrada incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #2 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #3 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #4 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #5 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #6 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #7 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else {
                            daoMenp.crear(menup.getPersona(), menup.getMesa(), menup.getTurno(), menup.getEntrada(), menup.getPlatoFue(), menup.getPostre(), menup.getCostoAdi());
                            vaciarCampos();
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        }
                    } else {
                        dialogoOk.textoLabel("Por favor ingrese una comida");
                        dialogoOk.visible();
                    }
                }
            } else {
                dialogoOk.textoLabel("Por favor seleccione una comida");
                dialogoOk.visible();
            }
        }
    }

    public void editar(MenuP men, int fila) {

        comPer.setModel(daoMenp.comboPer());
        mesaLabel.setText(men.getMesa());
        turnoLabel.setText(men.getTurno());

        filaU = fila;
    }

    public void actualizar() {
        if (filaU != 0) {

            String respuesta;
            if (true/*"Ninguna".equals(comMen.getSelectedItem().toString())*/) {
                //menup.setPersona("");

                respuesta = validar.validarMenuP(menup);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                //menup.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
                menup.setMesa(mesaLabel.getText());
                menup.setTurno(turnoLabel.getText());
                //menup.setMenu(Character.toString(comMen.getSelectedItem().toString().charAt(0)));

                respuesta = validar.validarMenuP(menup);

                if ("Longitud descripcion incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else {
                    if (!validarComidas()) {
                        if ("Longitud persona incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #1 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #2 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #3 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #4 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #5 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #6 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #7 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else {
                            //daoMenp.editar(Integer.parseInt(menup.getPersona()), menup.getMesa(), menup.getTurno(), menup.getMenu(), filaU);
                            vaciarCampos();
                            System.out.println("asd");
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                            System.out.println(filaU);
                            filaU = 0;
                        }
                    } else {
                        dialogoOk.textoLabel("Por favor ingrese una comida");
                        dialogoOk.visible();
                    }
                }
            }
        } else {
            dialogoOk.textoLabel("Por favor vuelva atrás");
            dialogoOk.visible();

        }
    }

    public void comboPer() {
        comPer.setVisible(false);
        comPer.removeAll();
        comPer.setModel(daoMenp.comboPer());
        comPer.setVisible(true);
    }

    public void comboTur() {
        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            mesaLabel.setText("");
            turnoLabel.setText("");
            inhabilitarCom();
            vaciarCom();
        } else {
            String[] datos = daoMenp.turno(Integer.valueOf(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            mesaLabel.setText(datos[0]);
            turnoLabel.setText(datos[1]);
        }
    }

    public void comboFecEnt(String dia) {
        String[] datos = daoMenp.comidaEnt(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comEnt1.setText(datos[0]);
            comEnt2.setText(datos[1]);
            comEnt3.setText(datos[2]);
            comEnt4.setText(datos[3]);
            comEnt5.setText(datos[4]);
            comEnt6.setText(datos[5]);
            comEnt7.setText(datos[6]);
        }
        comEnt1.setEnabled(!"".equals(comEnt1.getText()) && comEnt1.getText() != null);
        comEnt2.setEnabled(!"".equals(comEnt2.getText()) && comEnt2.getText() != null);
        comEnt3.setEnabled(!"".equals(comEnt3.getText()) && comEnt3.getText() != null);
        comEnt4.setEnabled(!"".equals(comEnt4.getText()) && comEnt4.getText() != null);
        comEnt5.setEnabled(!"".equals(comEnt5.getText()) && comEnt5.getText() != null);
        comEnt6.setEnabled(!"".equals(comEnt6.getText()) && comEnt6.getText() != null);
        comEnt7.setEnabled(!"".equals(comEnt7.getText()) && comEnt7.getText() != null);
    }

    public void comboFecPla(String dia) {
        String[] datos = daoMenp.comidaPla(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comPla1.setText(datos[0]);
            comPla2.setText(datos[1]);
            comPla3.setText(datos[2]);
            comPla4.setText(datos[3]);
            comPla5.setText(datos[4]);
            comPla6.setText(datos[5]);
            comPla7.setText(datos[6]);
        }
        comPla1.setEnabled(!"".equals(comPla1.getText()) && comPla1.getText() != null);
        comPla2.setEnabled(!"".equals(comPla2.getText()) && comPla2.getText() != null);
        comPla3.setEnabled(!"".equals(comPla3.getText()) && comPla3.getText() != null);
        comPla4.setEnabled(!"".equals(comPla4.getText()) && comPla4.getText() != null);
        comPla5.setEnabled(!"".equals(comPla5.getText()) && comPla5.getText() != null);
        comPla6.setEnabled(!"".equals(comPla6.getText()) && comPla6.getText() != null);
        comPla7.setEnabled(!"".equals(comPla7.getText()) && comPla7.getText() != null);
    }

    public void comboFecPos(String dia) {
        String[] datos = daoMenp.comidaPos(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comPos1.setText(datos[0]);
            comPos2.setText(datos[1]);
            comPos3.setText(datos[2]);
            comPos4.setText(datos[3]);
            comPos5.setText(datos[4]);
            comPos6.setText(datos[5]);
            comPos7.setText(datos[6]);
        }
        comPos1.setEnabled(!"".equals(comPos1.getText()) && comPos1.getText() != null);
        comPos2.setEnabled(!"".equals(comPos2.getText()) && comPos2.getText() != null);
        comPos3.setEnabled(!"".equals(comPos3.getText()) && comPos3.getText() != null);
        comPos4.setEnabled(!"".equals(comPos4.getText()) && comPos4.getText() != null);
        comPos5.setEnabled(!"".equals(comPos5.getText()) && comPos5.getText() != null);
        comPos6.setEnabled(!"".equals(comPos6.getText()) && comPos6.getText() != null);
        comPos7.setEnabled(!"".equals(comPos7.getText()) && comPos7.getText() != null);
    }

    public void comboFecCos(String dia) {
        String[] datos = daoMenp.comidaCos(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comCos1.setText(datos[0]);
            comCos2.setText(datos[1]);
            comCos3.setText(datos[2]);
            comCos4.setText(datos[3]);
            comCos5.setText(datos[4]);
            comCos6.setText(datos[5]);
            comCos7.setText(datos[6]);
        }
        comCos1.setEnabled(!"".equals(comCos1.getText()) && comCos1.getText() != null);
        comCos2.setEnabled(!"".equals(comCos2.getText()) && comCos2.getText() != null);
        comCos3.setEnabled(!"".equals(comCos3.getText()) && comCos3.getText() != null);
        comCos4.setEnabled(!"".equals(comCos4.getText()) && comCos4.getText() != null);
        comCos5.setEnabled(!"".equals(comCos5.getText()) && comCos5.getText() != null);
        comCos6.setEnabled(!"".equals(comCos6.getText()) && comCos6.getText() != null);
        comCos7.setEnabled(!"".equals(comCos7.getText()) && comCos7.getText() != null);
    }

    public void comboFec() {
        comFec.setVisible(false);
        comFec.removeAllItems();
        comFec.addItem("Lunes");
        comFec.addItem("Martes");
        comFec.addItem("Miercoles");
        comFec.addItem("Jueves");
        comFec.addItem("Viernes");
        comFec.addItem("Sábado");
        comFec.addItem("Domingo");
        comFec.setVisible(true);
    }

    public boolean entrada() {
        return ((comEnt1.isSelected() && !"".equals(comEnt1.getText()))
                || (comEnt2.isSelected() && !"".equals(comEnt2.getText()))
                || (comEnt3.isSelected() && !"".equals(comEnt3.getText()))
                || (comEnt4.isSelected() && !"".equals(comEnt4.getText()))
                || (comEnt5.isSelected() && !"".equals(comEnt5.getText()))
                || (comEnt6.isSelected() && !"".equals(comEnt6.getText())
                || (comEnt7.isSelected() && !"".equals(comEnt7.getText()))));
    }

    public boolean plato() {
        return (comPla1.isSelected()
                || comPla2.isSelected()
                || comPla3.isSelected()
                || comPla4.isSelected()
                || comPla5.isSelected()
                || comPla6.isSelected()
                || comPla7.isSelected());
    }

    public boolean postre() {
        return (comPos1.isSelected()
                || comPos2.isSelected()
                || comPos3.isSelected()
                || comPos4.isSelected()
                || comPos5.isSelected()
                || comPos6.isSelected()
                || comPos7.isSelected());
    }

    public boolean costo() {
        return (comCos1.isSelected()
                || comCos2.isSelected()
                || comCos3.isSelected()
                || comCos4.isSelected()
                || comCos5.isSelected()
                || comCos6.isSelected()
                || comCos7.isSelected());
    }

    public void entSel(boolean ent) {
        comEnt1.setEnabled((comEnt1.isSelected() || !ent) && !"".equals(comEnt1.getText()));
        comEnt2.setEnabled((comEnt2.isSelected() || !ent) && !"".equals(comEnt2.getText()));
        comEnt3.setEnabled((comEnt3.isSelected() || !ent) && !"".equals(comEnt3.getText()));
        comEnt4.setEnabled((comEnt4.isSelected() || !ent) && !"".equals(comEnt4.getText()));
        comEnt5.setEnabled((comEnt5.isSelected() || !ent) && !"".equals(comEnt5.getText()));
        comEnt6.setEnabled((comEnt6.isSelected() || !ent) && !"".equals(comEnt6.getText()));
        comEnt7.setEnabled((comEnt7.isSelected() || !ent) && !"".equals(comEnt7.getText()));
    }

    public void plaSel(boolean ent) {
        comPla1.setEnabled((comPla1.isSelected() || !ent) && !"".equals(comPla1.getText()));
        comPla2.setEnabled((comPla2.isSelected() || !ent) && !"".equals(comPla2.getText()));
        comPla3.setEnabled((comPla3.isSelected() || !ent) && !"".equals(comPla3.getText()));
        comPla4.setEnabled((comPla4.isSelected() || !ent) && !"".equals(comPla4.getText()));
        comPla5.setEnabled((comPla5.isSelected() || !ent) && !"".equals(comPla5.getText()));
        comPla6.setEnabled((comPla6.isSelected() || !ent) && !"".equals(comPla6.getText()));
        comPla7.setEnabled((comPla7.isSelected() || !ent) && !"".equals(comPla7.getText()));
    }

    public void posSel(boolean ent) {
        comPos1.setEnabled((comPos1.isSelected() || !ent) && !"".equals(comPos1.getText()));
        comPos2.setEnabled((comPos2.isSelected() || !ent) && !"".equals(comPos2.getText()));
        comPos3.setEnabled((comPos3.isSelected() || !ent) && !"".equals(comPos3.getText()));
        comPos4.setEnabled((comPos4.isSelected() || !ent) && !"".equals(comPos4.getText()));
        comPos5.setEnabled((comPos5.isSelected() || !ent) && !"".equals(comPos5.getText()));
        comPos6.setEnabled((comPos6.isSelected() || !ent) && !"".equals(comPos6.getText()));
        comPos7.setEnabled((comPos7.isSelected() || !ent) && !"".equals(comPos7.getText()));
    }

    public void cosSel(boolean ent) {
        comCos1.setEnabled((comCos1.isSelected() || !ent) && !"".equals(comCos1.getText()));
        comCos2.setEnabled((comCos2.isSelected() || !ent) && !"".equals(comCos2.getText()));
        comCos3.setEnabled((comCos3.isSelected() || !ent) && !"".equals(comCos3.getText()));
        comCos4.setEnabled((comCos4.isSelected() || !ent) && !"".equals(comCos4.getText()));
        comCos5.setEnabled((comCos5.isSelected() || !ent) && !"".equals(comCos5.getText()));
        comCos6.setEnabled((comCos6.isSelected() || !ent) && !"".equals(comCos6.getText()));
        comCos7.setEnabled((comCos7.isSelected() || !ent) && !"".equals(comCos7.getText()));
    }

    public void entCom() {
        if (entrada()) {
            if (comEnt1.isSelected()) {
                menup.setEntrada(comEnt1.getText());
            }
            if (comEnt2.isSelected()) {
                menup.setEntrada(comEnt2.getText());
            }
            if (comEnt3.isSelected()) {
                menup.setEntrada(comEnt3.getText());
            }
            if (comEnt4.isSelected()) {
                menup.setEntrada(comEnt4.getText());
            }
            if (comEnt5.isSelected()) {
                menup.setEntrada(comEnt5.getText());
            }
            if (comEnt6.isSelected()) {
                menup.setEntrada(comEnt6.getText());
            }
            if (comEnt7.isSelected()) {
                menup.setEntrada(comEnt7.getText());
            }
        } else {
            menup.setEntrada("");
        }
    }

    public void plaCom() {
        if (plato()) {
            if (comPla1.isSelected()) {
                menup.setPlatoFue(comPla1.getText());
            }
            if (comPla2.isSelected()) {
                menup.setPlatoFue(comPla2.getText());
            }
            if (comPla3.isSelected()) {
                menup.setPlatoFue(comPla3.getText());
            }
            if (comPla4.isSelected()) {
                menup.setPlatoFue(comPla4.getText());
            }
            if (comPla5.isSelected()) {
                menup.setPlatoFue(comPla5.getText());
            }
            if (comPla6.isSelected()) {
                menup.setPlatoFue(comPla6.getText());
            }
            if (comPla7.isSelected()) {
                menup.setPlatoFue(comPla7.getText());
            }
        } else {
            menup.setPlatoFue("");
        }
    }

    public void posCos() {
        if (postre()) {
            if (comPos1.isSelected()) {
                menup.setPostre(comPos1.getText());
            }
            if (comPos2.isSelected()) {
                menup.setPostre(comPos2.getText());
            }
            if (comPos3.isSelected()) {
                menup.setPostre(comPos3.getText());
            }
            if (comPos4.isSelected()) {
                menup.setPostre(comPos4.getText());
            }
            if (comPos5.isSelected()) {
                menup.setPostre(comPos5.getText());
            }
            if (comPos6.isSelected()) {
                menup.setPostre(comPos6.getText());
            }
            if (comPos7.isSelected()) {
                menup.setPostre(comPos7.getText());
            }
        } else {
            menup.setPostre("");
        }
    }

    public void cosCom() {
        if (costo()) {
            if (comCos1.isSelected()) {
                menup.setCostoAdi(comCos1.getText());
            }
            if (comCos2.isSelected()) {
                menup.setCostoAdi(comCos2.getText());
            }
            if (comCos3.isSelected()) {
                menup.setCostoAdi(comCos3.getText());
            }
            if (comCos4.isSelected()) {
                menup.setCostoAdi(comCos4.getText());
            }
            if (comCos5.isSelected()) {
                menup.setCostoAdi(comCos5.getText());
            }
            if (comCos6.isSelected()) {
                menup.setCostoAdi(comCos6.getText());
            }
            if (comCos7.isSelected()) {
                menup.setCostoAdi(comCos7.getText());
            }
        } else {
            menup.setCostoAdi("");
        }
    }

    public void nuevoVisible() {
        guardar.setVisible(true);
        editarNuevo.setVisible(false);
    }

    public void editarVisible() {
        guardar.setVisible(false);
        editarNuevo.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardar = new javax.swing.JLabel();
        editarNuevo = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        persona = new javax.swing.JLabel();
        comida1 = new javax.swing.JLabel();
        turnoLabel = new javax.swing.JLabel();
        comPer = new javax.swing.JComboBox<>();
        mesaTF = new javax.swing.JLabel();
        restauranteLabel = new javax.swing.JLabel();
        mesaLabel = new javax.swing.JLabel();
        comida4 = new javax.swing.JLabel();
        comida5 = new javax.swing.JLabel();
        comida6 = new javax.swing.JLabel();
        comida7 = new javax.swing.JLabel();
        comida3 = new javax.swing.JLabel();
        comida8 = new javax.swing.JLabel();
        comida9 = new javax.swing.JLabel();
        comPla1 = new javax.swing.JCheckBox();
        comEnt1 = new javax.swing.JCheckBox();
        comCos1 = new javax.swing.JCheckBox();
        comPos1 = new javax.swing.JCheckBox();
        comCos2 = new javax.swing.JCheckBox();
        comPos2 = new javax.swing.JCheckBox();
        comPla2 = new javax.swing.JCheckBox();
        comEnt2 = new javax.swing.JCheckBox();
        comPla4 = new javax.swing.JCheckBox();
        comEnt4 = new javax.swing.JCheckBox();
        comCos4 = new javax.swing.JCheckBox();
        comPos4 = new javax.swing.JCheckBox();
        comPla3 = new javax.swing.JCheckBox();
        comEnt3 = new javax.swing.JCheckBox();
        comPos3 = new javax.swing.JCheckBox();
        comCos3 = new javax.swing.JCheckBox();
        comPos7 = new javax.swing.JCheckBox();
        comPla7 = new javax.swing.JCheckBox();
        comCos7 = new javax.swing.JCheckBox();
        comEnt7 = new javax.swing.JCheckBox();
        comPos6 = new javax.swing.JCheckBox();
        comPos5 = new javax.swing.JCheckBox();
        comPla5 = new javax.swing.JCheckBox();
        comPla6 = new javax.swing.JCheckBox();
        comEnt6 = new javax.swing.JCheckBox();
        comEnt5 = new javax.swing.JCheckBox();
        comCos5 = new javax.swing.JCheckBox();
        comCos6 = new javax.swing.JCheckBox();
        comFec = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(164, 186, 191));

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });

        editarNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/test.png"))); // NOI18N
        editarNuevo.setToolTipText("Actualizar");
        editarNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNuevoMouseClicked(evt);
            }
        });

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida2.setText("Plato fuerte");

        persona.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        persona.setForeground(new java.awt.Color(36, 56, 63));
        persona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persona.setText("Persona");

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Turno");

        turnoLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        turnoLabel.setForeground(new java.awt.Color(36, 56, 63));
        turnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));
        comPer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comPerItemStateChanged(evt);
            }
        });

        mesaTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaTF.setForeground(new java.awt.Color(36, 56, 63));
        mesaTF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mesaTF.setText("Mesa");

        restauranteLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mesaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaLabel.setForeground(new java.awt.Color(36, 56, 63));
        mesaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        comida4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida4.setForeground(new java.awt.Color(36, 56, 63));
        comida4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida4.setText("Entrada");

        comida5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida5.setForeground(new java.awt.Color(36, 56, 63));
        comida5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida5.setText("Costo adicional");

        comida6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida6.setForeground(new java.awt.Color(36, 56, 63));
        comida6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida6.setText("Postre");

        comida7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida7.setForeground(new java.awt.Color(36, 56, 63));
        comida7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida7.setText("Entrada");

        comida3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida3.setForeground(new java.awt.Color(36, 56, 63));
        comida3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida3.setText("Plato fuerte");

        comida8.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida8.setForeground(new java.awt.Color(36, 56, 63));
        comida8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida8.setText("Postre");

        comida9.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida9.setForeground(new java.awt.Color(36, 56, 63));
        comida9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida9.setText("Costo adicional");

        comPla1.setBackground(new java.awt.Color(164, 186, 191));
        comPla1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla1.setForeground(new java.awt.Color(36, 56, 63));
        comPla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla1ActionPerformed(evt);
            }
        });

        comEnt1.setBackground(new java.awt.Color(164, 186, 191));
        comEnt1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt1.setForeground(new java.awt.Color(36, 56, 63));
        comEnt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt1ActionPerformed(evt);
            }
        });

        comCos1.setBackground(new java.awt.Color(164, 186, 191));
        comCos1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos1.setForeground(new java.awt.Color(36, 56, 63));
        comCos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos1ActionPerformed(evt);
            }
        });

        comPos1.setBackground(new java.awt.Color(164, 186, 191));
        comPos1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos1.setForeground(new java.awt.Color(36, 56, 63));
        comPos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos1ActionPerformed(evt);
            }
        });

        comCos2.setBackground(new java.awt.Color(164, 186, 191));
        comCos2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos2.setForeground(new java.awt.Color(36, 56, 63));
        comCos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos2ActionPerformed(evt);
            }
        });

        comPos2.setBackground(new java.awt.Color(164, 186, 191));
        comPos2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos2.setForeground(new java.awt.Color(36, 56, 63));
        comPos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos2ActionPerformed(evt);
            }
        });

        comPla2.setBackground(new java.awt.Color(164, 186, 191));
        comPla2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla2.setForeground(new java.awt.Color(36, 56, 63));
        comPla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla2ActionPerformed(evt);
            }
        });

        comEnt2.setBackground(new java.awt.Color(164, 186, 191));
        comEnt2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt2.setForeground(new java.awt.Color(36, 56, 63));
        comEnt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt2ActionPerformed(evt);
            }
        });

        comPla4.setBackground(new java.awt.Color(164, 186, 191));
        comPla4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla4.setForeground(new java.awt.Color(36, 56, 63));
        comPla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla4ActionPerformed(evt);
            }
        });

        comEnt4.setBackground(new java.awt.Color(164, 186, 191));
        comEnt4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt4.setForeground(new java.awt.Color(36, 56, 63));
        comEnt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt4ActionPerformed(evt);
            }
        });

        comCos4.setBackground(new java.awt.Color(164, 186, 191));
        comCos4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos4.setForeground(new java.awt.Color(36, 56, 63));
        comCos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos4ActionPerformed(evt);
            }
        });

        comPos4.setBackground(new java.awt.Color(164, 186, 191));
        comPos4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos4.setForeground(new java.awt.Color(36, 56, 63));
        comPos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos4ActionPerformed(evt);
            }
        });

        comPla3.setBackground(new java.awt.Color(164, 186, 191));
        comPla3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla3.setForeground(new java.awt.Color(36, 56, 63));
        comPla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla3ActionPerformed(evt);
            }
        });

        comEnt3.setBackground(new java.awt.Color(164, 186, 191));
        comEnt3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt3.setForeground(new java.awt.Color(36, 56, 63));
        comEnt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt3ActionPerformed(evt);
            }
        });

        comPos3.setBackground(new java.awt.Color(164, 186, 191));
        comPos3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos3.setForeground(new java.awt.Color(36, 56, 63));
        comPos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos3ActionPerformed(evt);
            }
        });

        comCos3.setBackground(new java.awt.Color(164, 186, 191));
        comCos3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos3.setForeground(new java.awt.Color(36, 56, 63));
        comCos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos3ActionPerformed(evt);
            }
        });

        comPos7.setBackground(new java.awt.Color(164, 186, 191));
        comPos7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos7.setForeground(new java.awt.Color(36, 56, 63));
        comPos7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos7ActionPerformed(evt);
            }
        });

        comPla7.setBackground(new java.awt.Color(164, 186, 191));
        comPla7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla7.setForeground(new java.awt.Color(36, 56, 63));
        comPla7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla7ActionPerformed(evt);
            }
        });

        comCos7.setBackground(new java.awt.Color(164, 186, 191));
        comCos7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos7.setForeground(new java.awt.Color(36, 56, 63));
        comCos7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos7ActionPerformed(evt);
            }
        });

        comEnt7.setBackground(new java.awt.Color(164, 186, 191));
        comEnt7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt7.setForeground(new java.awt.Color(36, 56, 63));
        comEnt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt7ActionPerformed(evt);
            }
        });

        comPos6.setBackground(new java.awt.Color(164, 186, 191));
        comPos6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos6.setForeground(new java.awt.Color(36, 56, 63));
        comPos6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos6ActionPerformed(evt);
            }
        });

        comPos5.setBackground(new java.awt.Color(164, 186, 191));
        comPos5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos5.setForeground(new java.awt.Color(36, 56, 63));
        comPos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPos5ActionPerformed(evt);
            }
        });

        comPla5.setBackground(new java.awt.Color(164, 186, 191));
        comPla5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla5.setForeground(new java.awt.Color(36, 56, 63));
        comPla5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla5ActionPerformed(evt);
            }
        });

        comPla6.setBackground(new java.awt.Color(164, 186, 191));
        comPla6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla6.setForeground(new java.awt.Color(36, 56, 63));
        comPla6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPla6ActionPerformed(evt);
            }
        });

        comEnt6.setBackground(new java.awt.Color(164, 186, 191));
        comEnt6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt6.setForeground(new java.awt.Color(36, 56, 63));
        comEnt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt6ActionPerformed(evt);
            }
        });

        comEnt5.setBackground(new java.awt.Color(164, 186, 191));
        comEnt5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt5.setForeground(new java.awt.Color(36, 56, 63));
        comEnt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEnt5ActionPerformed(evt);
            }
        });

        comCos5.setBackground(new java.awt.Color(164, 186, 191));
        comCos5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos5.setForeground(new java.awt.Color(36, 56, 63));
        comCos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos5ActionPerformed(evt);
            }
        });

        comCos6.setBackground(new java.awt.Color(164, 186, 191));
        comCos6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos6.setForeground(new java.awt.Color(36, 56, 63));
        comCos6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCos6ActionPerformed(evt);
            }
        });

        comFec.setBackground(new java.awt.Color(164, 186, 191));
        comFec.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comFec.setForeground(new java.awt.Color(36, 56, 63));
        comFec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comFecItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restauranteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(comFec, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(mesaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(mesaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(turnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(comEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(comPla1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comEnt6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comEnt7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comPla6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comPla7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comPos6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comPos7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comCos6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comCos7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(restauranteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(comFec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comEnt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comEnt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comPla6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comPla7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comPos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comPos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comCos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comCos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void comPerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comPerItemStateChanged
        comboTur();
        if (comPer.getSelectedIndex() != 0) {
            deseleccionarCom();
            comboFecEnt(comFec.getSelectedItem().toString());
            comboFecPla(comFec.getSelectedItem().toString());
            comboFecPos(comFec.getSelectedItem().toString());
            comboFecCos(comFec.getSelectedItem().toString());
        } else {
            vaciarCom();
            inhabilitarCom();
            deseleccionarCom();
            comFec.setSelectedIndex(0);
        }
    }//GEN-LAST:event_comPerItemStateChanged

    private void comFecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comFecItemStateChanged
        if (comPer.getSelectedIndex() != 0) {
            deseleccionarCom();
            comboFecEnt(comFec.getSelectedItem().toString());
            comboFecPla(comFec.getSelectedItem().toString());
            comboFecPos(comFec.getSelectedItem().toString());
            comboFecCos(comFec.getSelectedItem().toString());

        } else {
            vaciarCom();
            inhabilitarCom();
            deseleccionarCom();
        }
    }//GEN-LAST:event_comFecItemStateChanged

    private void comEnt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt1ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt1ActionPerformed

    private void comEnt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt2ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt2ActionPerformed

    private void comEnt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt3ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt3ActionPerformed

    private void comEnt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt4ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt4ActionPerformed

    private void comEnt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt5ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt5ActionPerformed

    private void comEnt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt6ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt6ActionPerformed

    private void comEnt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEnt7ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            entSel(entrada());
        }
    }//GEN-LAST:event_comEnt7ActionPerformed

    private void comPla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla1ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla1ActionPerformed

    private void comPla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla2ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla2ActionPerformed

    private void comPla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla3ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla3ActionPerformed

    private void comPla4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla4ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla4ActionPerformed

    private void comPla5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla5ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla5ActionPerformed

    private void comPla6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla6ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla6ActionPerformed

    private void comPla7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPla7ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            plaSel(plato());
        }
    }//GEN-LAST:event_comPla7ActionPerformed

    private void comPos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos1ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos1ActionPerformed

    private void comPos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos2ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos2ActionPerformed

    private void comPos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos3ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos3ActionPerformed

    private void comPos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos4ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos4ActionPerformed

    private void comPos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos5ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos5ActionPerformed

    private void comPos6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos6ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos6ActionPerformed

    private void comPos7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPos7ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            posSel(postre());
        }
    }//GEN-LAST:event_comPos7ActionPerformed

    private void comCos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos1ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos1ActionPerformed

    private void comCos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos2ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos2ActionPerformed

    private void comCos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos3ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos3ActionPerformed

    private void comCos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos4ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos4ActionPerformed

    private void comCos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos5ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos5ActionPerformed

    private void comCos6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos6ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos6ActionPerformed

    private void comCos7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCos7ActionPerformed
        if (comPer.getSelectedIndex() != 0) {
            cosSel(costo());
        }
    }//GEN-LAST:event_comCos7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox comCos1;
    private javax.swing.JCheckBox comCos2;
    private javax.swing.JCheckBox comCos3;
    private javax.swing.JCheckBox comCos4;
    private javax.swing.JCheckBox comCos5;
    private javax.swing.JCheckBox comCos6;
    private javax.swing.JCheckBox comCos7;
    private javax.swing.JCheckBox comEnt1;
    private javax.swing.JCheckBox comEnt2;
    private javax.swing.JCheckBox comEnt3;
    private javax.swing.JCheckBox comEnt4;
    private javax.swing.JCheckBox comEnt5;
    private javax.swing.JCheckBox comEnt6;
    private javax.swing.JCheckBox comEnt7;
    private javax.swing.JComboBox<String> comFec;
    private javax.swing.JComboBox<String> comPer;
    private javax.swing.JCheckBox comPla1;
    private javax.swing.JCheckBox comPla2;
    private javax.swing.JCheckBox comPla3;
    private javax.swing.JCheckBox comPla4;
    private javax.swing.JCheckBox comPla5;
    private javax.swing.JCheckBox comPla6;
    private javax.swing.JCheckBox comPla7;
    private javax.swing.JCheckBox comPos1;
    private javax.swing.JCheckBox comPos2;
    private javax.swing.JCheckBox comPos3;
    private javax.swing.JCheckBox comPos4;
    private javax.swing.JCheckBox comPos5;
    private javax.swing.JCheckBox comPos6;
    private javax.swing.JCheckBox comPos7;
    private javax.swing.JLabel comida1;
    private javax.swing.JLabel comida2;
    private javax.swing.JLabel comida3;
    private javax.swing.JLabel comida4;
    private javax.swing.JLabel comida5;
    private javax.swing.JLabel comida6;
    private javax.swing.JLabel comida7;
    private javax.swing.JLabel comida8;
    private javax.swing.JLabel comida9;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel mesaLabel;
    private javax.swing.JLabel mesaTF;
    private javax.swing.JLabel persona;
    private javax.swing.JLabel restauranteLabel;
    private javax.swing.JLabel turnoLabel;
    // End of variables declaration//GEN-END:variables
}
