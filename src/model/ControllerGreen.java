package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllerGreen{

    private ProjectGreen[] project;
    
    
    public ControllerGreen() {

		project = new ProjectGreen[10];

	}
    /**
     * Description: Allows show the Project with more Knoledges Units registered.
     * @return msg: messages with a Int.
     */
    public String projectNumMaxKnowledgeUnits() {
        String msg = " ";
        int numMax = 0;
        int units = 0;
        int maxProject = 0;

        for (int i = 0; i < project.length; i++) {
            units = 0;
            if (project[i]!=null){
                for (int j = 0; j < project[i].getStages().length; j++) {
                    for (int k = 0; k < project[i].getStages()[j].getUnitsCapsule().length; k++){
                        if(project[i].getStages()[j].getUnitsCapsule()[k]!=null){     
                            units +=1;
                            if (units > numMax){
                                
                                numMax = units;
                                maxProject = i;
                            }
                        }
                    }
                }
            }
        }
       
        msg = project[maxProject].getNameProject()+" has "+numMax+" knowledge units.";
        units = 0;

        return msg;
    }
    /**
     * Description: Allows register one project in the system.
     * @param nameProject
     * @param nameCostumer
     * @param nameManager
     * @param startDate
     * @param endDate
     * @param projectBudget
     * @param managerTell
     * @param costumerTell
     * @return Boolean.
     */
    public boolean registerproject(String nameProject, String nameCostumer, String nameManager, Calendar startDate, Calendar endDate, int projectBudget, int managerTell, int costumerTell) {

		ProjectGreen newproject = new ProjectGreen(nameProject, nameCostumer, nameManager, startDate, endDate, projectBudget, managerTell, costumerTell);
        for (int i = 0; i <project.length; i++) {

            if (project[i] == null){
                project[i] = newproject;
                return true;
            }
            
        }

		return false;
	}
    /**
     * Description: Allows create a calendar.
     * @param day
     * @param month
     * @param year
     * @return calendar.
     */
    public Calendar creatCalendar (int day, int month, int year) {
		Calendar calendar = new GregorianCalendar(day, month, year);
		return calendar;
	}
    /**
     * Description: Allows create Knowledge Unit for one stage of the projects
     * @param type
     * @param identifier
     * @param description
     * @param learnedLessons
     * @param positionCollaborator
     * @param name
     * @param collaborator
     * @param projects
     * @param stages
     * @return Boolean.
     */
    public boolean registerKnowledgeUnitCollaborator(int type,String identifier, String description, String learnedLessons, String positionCollaborator, String name, int collaborator, int projects, int stages) {
        TypeKnowledge typeKU = TypeKnowledge.TECNICO;
        System.out.println(type);
        switch(type){
            case 1:
                typeKU = TypeKnowledge.TECNICO;
            break;
            case 2:
                typeKU = TypeKnowledge.EXPERIENCIAS;
            break;

            case 3:
                typeKU = TypeKnowledge.GESTION;
            break;

            case 4:
                typeKU = TypeKnowledge.DOMINIO;
            break;
        }

        CollaboratorGreen collaboratorKU = CollaboratorGreen.COLLABORATOR;
        switch(collaborator){
            case 1:
                collaboratorKU = CollaboratorGreen.COLLABORATOR;
            break;
            case 2:
                collaboratorKU = CollaboratorGreen.WORKER;
            break;
        }
        
		KnowledgeGreen newCapsule = new KnowledgeGreen(identifier,description,typeKU,learnedLessons,positionCollaborator, name, collaboratorKU);
        
        for (int i = 0; i <project[projects].getStages()[stages].getUnits().length(); i++) {
            
        
            if (project[projects].getStages()[stages].getUnitsCapsule()[i] == null){
                project[projects].getStages()[stages].getUnitsCapsule()[i] = newCapsule;

                return true;
            }
            
        }

		return false;
	}
    /**
     * Description: Allows show all Knoledge Unit solicited by the user in one project and one stage
     * @param project
     * @param stage
     * @return msg
     */
    public String KnowledgeUnits(int project, int stage) {
        String msg = " ";
        msg= this.project[project].getStages()[stage].getUnits();
        return msg;
    }
    /**
     * Description: Allows see the Knoledge Units for type
     * @param projects
     * @param stages
     * @return msg
     */
    public String getKnowledgeUnits(int projects,int stages) {
        String msg = " ";
        msg += this.project[projects].getStages()[stages].getAllKnowledgeUnits();;
        return msg;
    }
    /**
     * Description: Allows know wich is the Knoledge Units depending by the type
     * @return msg
     */
    public String getAllKnowledgeUnits() {

		String msg = " ";
        int domain = 0;
        int experiences = 0;
        int gestion = 0;
        int technical = 0;
        for (int i = 0; i < this.project.length; i++) {
            if(this.project[i] != null){
                for (int j = 0; j < this.project[i].getStages().length; j++) {
                    for (int j2 = 0; j2 < this.project[i].getStages()[j].getUnitsCapsule().length; j2++) {
                        if(this.project[i].getStages()[j].getUnitsCapsule()[j2] != null){
                            if (this.project[i].getStages()[j].getUnitsCapsule()[j2].getType() == TypeKnowledge.DOMINIO){
                                domain =+ 1;
                            }else if(this.project[i].getStages()[j].getUnitsCapsule()[j2].getType() == TypeKnowledge.EXPERIENCIAS){
                                experiences =+ 1;
                            }else if(this.project[i].getStages()[j].getUnitsCapsule()[j2].getType() == TypeKnowledge.GESTION){
                                gestion =+ 1;
                            }else{
                                technical =+1;
                            }
                        }
                    }
                }
            }
        }
       
        msg += "Domain: "+domain+"\nExperiences: "+experiences+"\nGestion: "+gestion+"\nTechnical: "+technical; 

		return msg;

	}
    /**
     * Description: Allows see the Knoledge Units aproved by the user.
     * @param project
     * @param stage
     * @return msg
     */
    public String getAproveKnowledgeUnits(int project, int stage) {

		String msg = " ";
        msg = this.project[project].getStages()[stage].getAprove();
		return msg;

	}
    /**
     * Description: Allows see the Knoledge Units publish for the user
     * @param project
     * @param stages
     * @return msg
     */
    public String showCapsulePublish(int project, int stages) {
        String msg = "";
		msg = this.project[project].getStages()[stages].getAllKnowledgeUnitsPublish();
        return msg;
    }
    /**
     * Description: Allows see the lessons learned depending by the type in the stage.
     * @param stages
     * @return msg 
     */
    public String showLessons(int stages){
        String msg = " ";
        for (int i = 0; i < project.length; i++) {
            if(project[i]!=null){
                for (int j = 0; j < project[i].getStages().length; j++) {
                   for (int j2 = 0; j2 < project[i].getStages()[j].getUnitsCapsule().length; j2++) {
                    if(project[i].getStages()[j].getUnitsCapsule()[j2]!=null){
                        if(stages==1){
                            if(project[i].getStages()[j].getUnitsCapsule()[j2].getType().equals(TypeKnowledge.EXPERIENCIAS)){
                                msg += (i+1)+". "+project[i].getStages()[j].getUnitsCapsule()[j2].getLearnedLessons()+"\n";
                            }
                        }else if(stages == 2){
                            if(project[i].getStages()[j].getUnitsCapsule()[j2].getType().equals(TypeKnowledge.DOMINIO)){
                                msg += (i+1)+". "+project[i].getStages()[j].getUnitsCapsule()[j2].getLearnedLessons()+"\n";
                            }
                        }else if(stages==3){
                            if(project[i].getStages()[j].getUnitsCapsule()[j2].getType().equals(TypeKnowledge.GESTION)){
                                msg += (i+1)+". "+project[i].getStages()[j].getUnitsCapsule()[j2].getLearnedLessons()+"\n";
                            }
                        }else if(stages==4) {
                         if (project[i].getStages()[j].getUnitsCapsule()[j2].getType().equals(TypeKnowledge.TECNICO)) {
                                msg += (i+1)+". "+project[i].getStages()[j].getUnitsCapsule()[j2].getLearnedLessons()+"\n";
                            }
                        }
                    }
                    
                }
            }
        }
            
    }
        return msg;
    }
    /**
     * Description: Allows publish a Knoledge Units
     * @param status
     * @param project
     * @param stages
     * @param units
     */
    public void publish(int status, int project, int stages, int units) {
		if (status==1){
			this.project[project].getStages()[stages].getUnitsCapsule()[units].setStatusPublication(StatusPublication.DONT_PUBLISH);
		}else{
			this.project[project].getStages()[stages].getUnitsCapsule()[units].setStatusPublication(StatusPublication.PUBLISH);
		}
		
	}
    /**
     * Description: Allows aprove Knoledge Units
     * @param status
     * @param project
     * @param stages
     * @param units
     */
    public void approveKnowledgeUnit(int status, int project, int stages, int units) {
        if (status==1){
			this.project[project].getStages()[stages].getUnitsCapsule()[units].setStatus(StatusKnowledgeUnits.NO_APROBADA);
		}else{
			this.project[project].getStages()[stages].getUnitsCapsule()[units].setStatus(StatusKnowledgeUnits.APROBADA);
		}
	}
    /**
     * Description: Allows wich user registered Knoledge Units in the system
     * @param name
     * @return msg
     */
    public String getAllKnowledgeUnitsforCollaborator(String name) {
        String msg = " ";
        for (int i = 0; i < this.project.length; i++) {
            if(this.project[i] != null){
                for (int j = 0; j < this.project[i].getStages().length; j++) {
                    for (int j2 = 0; j2 < this.project[i].getStages()[j].getUnitsCapsule().length; j2++) {
                        if(this.project[i].getStages()[j].getUnitsCapsule()[j2] != null){
                           if(this.project[i].getStages()[j].getUnitsCapsule()[j2].getTypeAssistant()==CollaboratorGreen.COLLABORATOR){
                                if(this.project[i].getStages()[j].getUnitsCapsule()[j2].getNameCollaborator().equals(name)){
                                    msg += "Este usuario ha registrado capsulas";
                                }
                           }
                        }
                    }
                    
                }

            }
        }
        return msg;
    }
    /**
     * Description: Allows see the name of one project determinated
     * @return msg
     */
    public String getAllProtject() {

		String msg = "";

        for (int i = 0; i < project.length; i++) {
           if (project[i]!=null){
                msg += "\n"+(i+1)+". Project:"+project[i].getNameProject();  
           }
        }

		return msg;

	}
    /**
     * Description: Allows end a one stage and active the next one.
     * @param project
     * @param stage
     */
    public void endStage(int project, int stage){

        if(this.project[project].getStages()[stage].getStageActive() == true){
            this.project[project].getStages()[stage].setInactive();
            this.project[project].getStages()[stage].setFinalDateR();
            this.project[project].getStages()[stage+1].setActive();
            this.project[project].getStages()[stage+1].setRInitialDate();
            System.out.println("The stage has been inactivated");
        }
        else{
            System.out.println("This stage has been previously inactive");
        }

    }
    /**
     * Description: Allows see the stages in one project.
     * @param projects
     * @return msg
     */
    public String getAllStages(int projects) {


		String msg = " ";

        for (int i = 0; i < project[projects].getStages().length; i++) {
           if (project[projects].getStages()!=null){
                msg += "\n"+(i+1)+". Stage:"+project[projects].getStages()[i].getStage();  
           }
        }

		return msg;

	}
    /**
     * Description: Allows you to search for keywords of lessons learned..
     * @param keyword
     * @return msg
     */
    public String hashtags(String keyword) {
        String msg = " ";

        for (int i = 0; i < project.length; i++) {
            
            if (project[i]!=null){

                for (int j = 0; j < project[i].getStages().length; j++) {
                    
                    for (int k = 0; k < project[i].getStages()[j].getUnitsCapsule().length; k++) {
                        
                        if (project[i].getStages()[j].getUnitsCapsule()[k]!=null){

                            if(this.project[i].getStages()[j].getUnitsCapsule()[k].getStatus()==StatusKnowledgeUnits.APROBADA && this.project[i].getStages()[j].getUnitsCapsule()[k].getStatusPublication()==StatusPublication.PUBLISH){

                                if(project[i].getStages()[j].getUnitsCapsule()[k].getLearnedLessons().contains(keyword)){

                                    msg += (i+1)+" Project :"+project[i].getStages()[j].getUnitsCapsule()[k].getLearnedLessons();

                                }
                            }else{
                                msg += "Knowledge Unit Don´t Aproved or Don´t Published"; 
                            }

                        }
                    }
                }
            }

        }
        return msg;
    }
}