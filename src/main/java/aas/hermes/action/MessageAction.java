/*
 * Controller for data model Message.
 */
package aas.hermes.action;

/**
 * Package que define el controlador para la el modelo de datos Message
 *
 * @author David
 */
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import aas.hermes.dao.javabeans.Message;
import aas.hermes.dao.model.ModelMessageDAO;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 * Clase de acción que proporciona operaciones con mensajes.
 * @author dgarcia25
 */
public class MessageAction extends ActionSupport implements SessionAware, Preparable, ModelDriven {

    private Message message;
    private String flight;
    private String flightNumber;
    private String smi;
    private List<String> flightList;
    private int idFlight;
    private int idMessage;
    private Map<String, Object> sessionMap;
    private List<Message> listaResultados;
    private List<Message> newMessages;

    /**
     * Devuelve una lista con los 10 últimos mensajes añadidos a la base de
     * datos.
     * @return Lista de mensajes.
     */
    public List<Message> getNewMessages() {
        return newMessages;
    }

    /**
     * Asigna un valor a la lista de los 10 últimos mensajes.
     * @param newMessages Lista de mensajes.
     */
    public void setNewMessages(List<Message> newMessages) {
        this.newMessages = newMessages;
    }

    /**
     * Devuelve los valores de la sesión de usuario actual.
     * @return Valores de la sesión de usuario.
     */
    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     *  Asigna valores a una sesión de usuario.
     * @param sessionMap Valores para la sesión de usuario.
     */
    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * Recupera un número de vuelo.
     * @return Número de vuelo.
     */
    public String getFlight() {
        return flight;
    }

    /**
     * Asigna un número de vuelo.
     * @param flight Número de vuelo.
     */
    public void setFlight(String flight) {
        this.flight = flight;
    }

    /**
     * Recupera un identificador de tipo de mensaje.
     * @return Identificador de tipo de mensaje.
     */
    public String getSmi() {
        return smi;
    }

    /**
     * Asigna un identificador de tipo de mensaje.
     * @param smi
     */
    public void setSmi(String smi) {
        this.smi = smi;
    }

    /**
     * Recupera un identificador de mensaje.
     * @return Identificador de mensaje.
     */
    public int getIdMessage() {
        return idMessage;
    }

    /**
     * Asigna un identificador de mensaje.
     * @param idMessage Identificador de mensaje.
     */
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Recupera un mensaje.
     * @return Mensaje.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Asigna valor a un mensaje.
     * @param message Valor del mensaje.
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * Recupera un número de vuelo.
     * @return Número de vuelo.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Asigna un número de vuelo.
     * @param flightNumber Número de vuelo.
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Recupera una lista de números de vuelo.
     * @return Lista de números de vuelo.
     * 
     */
    public List<String> getFlightList() {

        ModelMessageDAO ModelMessageDAO = new ModelMessageDAO();
        flightList = (ArrayList<String>) ModelMessageDAO.getFlightList();
        return flightList;
    }

    /**
     * Asigna valor a una lista de números de vuelo.
     * @param flightList Lista de números de vuelo.
     */
    public void setFlightList(List<String> flightList) {
        this.flightList = flightList;
    }

    /**
     * Recupera el identificador de un número de vuelo.
     * @return Identificador del número de vuelo.
     */
    public int getIdFlight() {
        return idFlight;
    }

    /**
     * Asigna un valor al identificador del número de vuelo.
     * @param idFlight Identificador del número de vuelo.
     */
    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    /**
     *
     * @param map
     */
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void prepare() throws Exception {
        ModelMessageDAO modelMessageDAO = new ModelMessageDAO();
        // en creación, crear un nuevo objeto vacío 
        if (idMessage == 0) {
            message = new Message();
        } // en modificación, devolver la información del objeto 
        else {

            message = modelMessageDAO.getMessage(idMessage);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Object getModel() {
        return message;
    }

    /**
     * Devuelve una lista de usuarios.
     * @return Lista de usuarios.
     */
        public String main() {
        // esta acción requiere sesión de usuario, por lo que se comprueba.
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session.getAttribute("role").equals("user")) {
            ModelMessageDAO ModelMessageDAO = new ModelMessageDAO();
            flightList = (ArrayList<String>) ModelMessageDAO.getFlightList();
            return "user";
        } else if (session.getAttribute("role").equals("admin")) {
            return "admin";
        }

        return "input";
    }

    /**
     * Devuelve una lista de mensajes de vuelo.
     * @return Lista de mensajes de vuelos.
     */
    public String flightMessages() {
        // esta acción requiere sesión de usuario, por lo que se comprueba.
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session.getAttribute("role").equals("user")) {
            ModelMessageDAO ModelMessageDAO = new ModelMessageDAO();
            listaResultados = (ArrayList<Message>) ModelMessageDAO.getListaResultados(this.flight);
            this.sessionMap.put("flight", this.flightNumber);
            return SUCCESS;
        } else {
            session.invalidate();
            return "input";
        }
    }

    /**
     * Devuelve una lista de mensajes.
     * @return Lista de mensajes.
     */
    public List<Message> getListaResultados() {
        return listaResultados;
    }

    /**
     * Asigna una lista de mensajes a la lista de resultados.
     * @param listaResultados Lista de mensajes.
     */
    public void setListaResultados(List<Message> listaResultados) {
        this.listaResultados = listaResultados;
    }

    /**
     * Devuelve una lista con los 10 últimos mensajes.
     * @return Lista de mensajes.
     */
    public String newMessages() {
        // esta acción requiere sesión de usuario, por lo que se comprueba.
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session.getAttribute("role").equals("admin")) {
            ModelMessageDAO ModelMessageDAO = new ModelMessageDAO();
            newMessages = (ArrayList<Message>) ModelMessageDAO.getNewMessages();
            return SUCCESS;
        } else {
            session.invalidate();
            return "input";
        }
    }
}
