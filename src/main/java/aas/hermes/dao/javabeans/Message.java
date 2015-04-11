/*
 * Created by me and myself.
 */
package aas.hermes.dao.javabeans;

/**
 * Package de definición del javabean Message.
 * @author David
 */
public class Message {
    private String smi;
    private String tex;
    private String tex_flt;
    private String tex_date;
    private String tex_reg;
    private int id;
    
    /**
     * Constructor de clase Message. Crea una instancia a la clase Message.
     */
    public Message() {
    }

    /**
     * Devuelve el valor del atributo SMI.
     * @return smi: Standard Message Identificator
     */
    public String getSmi() {
        return smi;
    }

    /**
     * Asigna un valor al campo SMI.
     * @param smi Standard Message Identificator.
     */
    public void setSmi(String smi) {
        this.smi = smi;
    }

    /**
     * Devuelve el valor del atributo Tex
     * @return tex: Texto del cuerpo del mensaje.
     */
    public String getTex() {
        return tex;
    }

    /**
     * Asigna un valor al campo Tex.
     * @param tex Texto del cuerpo del mensaje.
     */
    public void setTex(String tex) {
        this.tex = tex;
    }

    /**
     * Devuelve el valor del atributo tex_flt
     * @return tex_flt: Número de vuelo del mensaje.
     */
    public String getTex_flt() {
        return tex_flt;
    }

    /**
     * Asigna un valor al campo tex_flt
     * @param tex_flt Número de vuelo del mensaje.
     */
    public void setTex_flt(String tex_flt) {
        this.tex_flt = tex_flt;
    }

    /**
     * Devuelve el valor del atritbuto tex_date
     * @return tex_date: fecha del vuelo del mensaje.
     */
    public String getTex_date() {
        return tex_date;
    }

    /**
     * Asigna un valor al campo tex_date
     * @param tex_date fecha del vuelo del mensaje.
     */
    public void setTex_date(String tex_date) {
        this.tex_date = tex_date;
    }

    /**
     * Devuelve el valor del atributo tex_reg
     * @return tex_reg matrícula del vuelo del mensaje.
     */
    public String getTex_reg() {
        return tex_reg;
    }

    /**
     * Asigna un valor al atributo tex_reg
     * @param tex_reg matrícula del vuelo del mensaje.
     */
    public void setTex_reg(String tex_reg) {
        this.tex_reg = tex_reg;
    }

    /**
     * Devuelve el valor del atributo Id.
     * @return Id: identificador único del mensaje.
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna un valor al atributo id
     * @param id identificador único del mensaje.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
