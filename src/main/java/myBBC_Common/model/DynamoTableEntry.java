package myBBC_Common.model;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 29/04/15
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public interface DynamoTableEntry {
    String getPersonId();
    void setPersonId(String personId);
    String getName();
    void setName(String name);
    String getOccupation();
    void setOccupation(String occupation);
}
