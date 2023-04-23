package model;

import java.util.Calendar;

public class Stage {
    
    private Calendar initialDateP;
    private Calendar initialDateR;
    private Calendar finalDateP;
    private Calendar finalDateR;
    private TypeStage stage;
    private Boolean statusStage;
    private KnowledgeGreen[] unitsCapsule;

    public Stage(Calendar initialDateP, Calendar finalDateP, TypeStage stage, boolean statusStage) {
		this.initialDateP = initialDateP;
        this.finalDateP = finalDateP;
        this.initialDateR = null;
        this.finalDateR = null;
		this.stage = stage;
        this.statusStage = statusStage;
        unitsCapsule = new KnowledgeGreen[50];
	}
    public void setInactive(){
        statusStage=false;
    }
    public boolean getStageActive(){
        return statusStage;
    }
    public void setFinalDateR(){
        this.finalDateR = Calendar.getInstance();
    }
    public void setRInitialDate(){
        this.initialDateR = Calendar.getInstance();
    }
    public void setActive(){
        statusStage=true;
    }
    /**
     * Description: Allows see the type of one Knoledge Units. 
     * @return msg
     */
    public String getAllKnowledgeUnits() {

		String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                 msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier() +" and the Type is:  "+unitsCapsule[i].getType();  
            }
         }

		return msg;

	}
    /**
     * Description: Allows get the status Aproved or Don´t aproved of the one Knoledge Units.
     * @return msg
     */
    public String getAprove() {

		String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                 msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier() +" and the status is:  "+unitsCapsule[i].getStatus();  
            }
         }

		return msg;

	}
    /**
     * Description: Allows get the status publish or Don´t publhis of the one Knoledge Units.
     * @return msg
     */
    public String getAllKnowledgeUnitsPublish() {

		String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                 msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier() +" and the status is:  "+unitsCapsule[i].getStatusPublication();  
            }
         }

		return msg;

	}
    /**
     * Description: Allows get the identifier of the one Knoledge Units.
     * @return
     */
    public String getUnits() {

		String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                 msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier();  
            }
         }

		return msg;

	}
    /**
     * Description: Allows get the identifier of the one Knoledge Units.
     * @return msg
     */
    public String getAllLessons() {

		String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                 msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier() +" and the learned lesson is:  "+unitsCapsule[i].getLearnedLessons();  
            }
         }

		return msg;

	}
    /**
     * Description: Allows the learned lessons in one Knoledge Units.
     * @return msg 
     */
    public String getLessonsExperiences() {
        String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                if(unitsCapsule[i].getType()==TypeKnowledge.EXPERIENCIAS){
                    msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier() +" and the learned lesson Experiences are:  "+unitsCapsule[i].getLearnedLessons();
                }  
            }
         }

		return msg;

    }
    /**
     * Description: Allows the get the name of collaborator registered Knoledge Units
     * @return msg
     */
    public String getCollaborator() {

		String msg = " ";
        for (int i = 0; i < unitsCapsule.length; i++) {
            if (unitsCapsule[i]!=null){
                 msg += "\n"+(i+1)+". Identifier: "+unitsCapsule[i].getIdentifier() +" and the Type Collaborator is:  "+unitsCapsule[i].getTypeAssistant()+ " Name: "+unitsCapsule[i].getNameCollaborator();  
            }
         }

		return msg;

	}
    /**
     * Description: Allows get the array of Knoledge Units.
     * @return
     */
    public KnowledgeGreen[] getUnitsCapsule(){
        return unitsCapsule;
    }
    /**
     * Description: Allows set the Knoledge Units
     * @param unitsCapsule
     */
    public void setUnitsCapsule(KnowledgeGreen[] unitsCapsule) {
        this.unitsCapsule = unitsCapsule;
    }

    public void setInitialDateR(Calendar initialDateR) {
        this.initialDateR = initialDateR;
    }
    public void setFinalDateR(Calendar finalDateR) {
        this.finalDateR = finalDateR;
    }
    public TypeStage getStage() {
        return stage;
    }
    /**
     * 
     * @param stage
     */
    public void setStage(TypeStage stage) {
        this.stage = stage;
    }
    /**
     * 
     * @param statusStage
     */
    public void setStatusStage(Boolean statusStage) {
        this.statusStage = statusStage;
    }
    /**
     * 
     * @param initialDateP
     */
    public void setInitialDateP(Calendar initialDateP){
        this.initialDateP = initialDateP;
    }
    /**
     * 
     * @param finalDateP
     */
    public void setFinalDateP(Calendar finalDateP){
        this.finalDateP = finalDateP;
    }
    /**
     * 
     * @return
     */
    public Calendar getFinalDateR() {
        return finalDateR;
    }
    /**
     * 
     * @return
     */
    public Calendar getInitialDateR() {
        return initialDateR;
    }
    /**
     * 
     * @return
     */
    public Calendar getFinalDateP(){
        return finalDateP;
    }
    /**
     * 
     * @return
     */
    public Calendar getInitialDateP() {
        return initialDateP;
    }
    /**
     * 
     * @return
     */
    public TypeStage getTypeStage() {
        return stage;
    }
    /**
     * 
     * @return
     */
    public boolean getStatusStage() {
        return statusStage;        
    }
    /**
     * 
     */
    public void setInitialDateR() {
        this.finalDateR = Calendar.getInstance();
        
    }
}
