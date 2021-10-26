package edu.northeastern.huang;

import java.util.HashMap;
import java.util.UUID;

public class Projector {

    private UUID projectorId;
    static HashMap<Integer,Projector> projects = new HashMap<>();

    private Projector(){
        projectorId = UUID.randomUUID();
    }

    private static Object obj = new Object();

    public static Projector getProjector(Integer id){

        if(!projects.containsKey(id)){
            synchronized (obj){
                if(!projects.containsKey(id)){
                    projects.put(id,new Projector());
                }
            }
        }
        return projects.get(id);
    }

    public UUID getProjectorId() {
        return projectorId;
    }

    public void setProjectorId(UUID projectorId) {
        this.projectorId = projectorId;
    }
}
