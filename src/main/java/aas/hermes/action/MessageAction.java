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

public class MessageAction extends ActionSupport implements SessionAware, Preparable, ModelDriven {

    private Message message;
    private String flightNumber;
    private String smi;
    private List<String> flightList;
    private int idFlight;
    private int idMessage;
    private Map<String, Object> sessionMap;

    public String getSmi() {
        return smi;
    }

    public void setSmi(String smi) {
        this.smi = smi;
    }

    
    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public List<String> getFlightList() {
         ModelMessageDAO ModelMessageDAO = new ModelMessageDAO();
        flightList = (ArrayList<String>) ModelMessageDAO.getFlightList();
        return flightList;
    }

    public void setFlightList(List<String> flightList) {
        this.flightList = flightList;
    }

    public int getIdFlight() {
        return idFlight;
    }

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
    
    // devolver la lista de clientes tras la recuperación 
    public String flightList() {
        ModelMessageDAO ModelMessageDAO = new ModelMessageDAO();
        flightList = (ArrayList<String>) ModelMessageDAO.getFlightList();
        return SUCCESS;
    }
}
