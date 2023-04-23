package ui;

import java.util.Scanner;

import model.ControllerGreen;

public class GreenSQA {

    private Scanner sc;
	private ControllerGreen controllerGreen;

    public GreenSQA() {

		sc = new Scanner(System.in);
		controllerGreen = new ControllerGreen();
	}

   
    public static void main(String[] args) {

		GreenSQA exe = new GreenSQA();
		exe.menu();

	}
    
    private void menu() {
        System.out.println("The menu is as follows.");
		boolean cond = false;
        while(!cond){
            System.out.println("1. Create a project.");
            System.out.println("2. Complete stage of a Project.");
            System.out.println("3. Register a knowledge unit.");
            System.out.println("4. Aprove a knowledge unit.");
            System.out.println("5. Publish Knowledge unit.");
            System.out.println("6. Show all capsule register in the system for type.");
            System.out.println("7. Show lessons learned from projects at a particular stage.");
            System.out.println("8. Project with more Registered Capsules.(P)");
            System.out.println("9. Capsules Registered by a Collaborator in a project.");
            System.out.println("10. Report of situations and lessons in the Approved and Published Capsules.");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    registerproject();
                break;

                case 2:
                    finishStage();
                break;

                case 3:
                    registerKnowledgeUnit();
                break;

                case 4:
                    approveKnowledgeUnit();
                break;

                case 5:
                    publishCapsule();
                break;

                case 6:
                    showAllKnowledgeUnits();
                break;

                case 7:
                    showLessons();
                break;

                case 8:
                    System.out.println(controllerGreen.projectNumMaxKnowledgeUnits());
                break;

                case 9:
                    capsuleRegisterforCollaborator();
                break;

                case 10:
                    hashtag();
                break;
            }
        }
    }
    
    public void hashtag() {
        sc.nextLine();

        System.out.println("Term you wish to find information about:");
        String keyword = sc.nextLine();

        System.out.println(controllerGreen.hashtags(keyword));
    }
    public void finishStage() {


        System.out.println("Enter the position of the project that you want to acces:");
        System.out.println(controllerGreen.getAllProtject());
        int project = sc.nextInt();

        System.out.println("Enter the position of the stage that you want to acces");
        System.out.println(controllerGreen.getAllStages(project-1));
        int stage = sc.nextInt();

        controllerGreen.endStage(project-1, stage-1);
    }
    private void registerproject() {

        System.out.println("Enter the information of the project below");
        sc.nextLine();

        System.out.println("Enter project name");
        String nameProject = sc.nextLine();

        System.out.println("Enter costumer name");
        String nameCostumer = sc.nextLine();

        System.out.println("Enter manager Name");
        String nameManager = sc.nextLine();

        System.out.println("Enter the start date below");
		System.out.println("Enter the day");
        int dayinitial = sc.nextInt();
		System.out.println("Enter the month");
		int monthinitial = sc.nextInt();
		System.out.println("Enter the year");
		int yearinitial = sc.nextInt();
    
        System.out.println("Enter the final date below");
        System.out.println("Enter the day");
        int dayfinal = sc.nextInt();
        System.out.println("Enter the month");
        int monthfinal = sc.nextInt();
        System.out.println("Enter the year");
        int yearfinal = sc.nextInt();
      
        System.out.println("Enter the the project budget");
        int projectBudget = sc.nextInt();

        System.out.println("Tell of Manager");
        int managerTell = sc.nextInt();

        System.out.println("Tell of Costumer");
        int costumerTell = sc.nextInt();

        if (controllerGreen.registerproject(nameProject, nameCostumer, nameManager, controllerGreen.creatCalendar(dayinitial, monthinitial, yearinitial), controllerGreen.creatCalendar(dayfinal, monthfinal, yearfinal), projectBudget, managerTell, costumerTell)==true){
			System.out.println("registered Project.");
		}else{
			System.out.println("Memory full, can not register the Project");
		}
    }
    
    private void registerKnowledgeUnit() {

        System.out.println("to which project do you want to register a capsule");
        String ConsultaProyectos = controllerGreen.getAllProtject();
        System.out.println("Projects: ");
        System.out.println(ConsultaProyectos);
        int projects = sc.nextInt();

        System.out.println("to which Stages do you want to register a capsule");
        System.out.println("Stages: ");
        String ConsultaEtapas = controllerGreen.getAllStages(projects-1);
        System.out.println(ConsultaEtapas);
        int stages = sc.nextInt();

        String consulta = controllerGreen.getKnowledgeUnits(projects-1, stages-1);
        if (consulta.equals(" ")){
            System.out.println("There are no registered capsules");
        }else{
            System.out.println(consulta);
        }
		System.out.println("Enter the information of the capsules below.");
        sc.nextLine();

		System.out.println("Enter the type of capsule. (1. técnico 2. experiencias 3. gestion  4. dominio)");
        int type = sc.nextInt();
        System.out.println(type);
        sc.nextLine();

		System.out.println("Enter a identifier: ej: A002");
        String identifier = sc.nextLine();

		System.out.println("Enter the description:");
        String description = sc.nextLine();

		System.out.println("Enter the lesson learned:");
        String learnedLessons = sc.nextLine();

        System.out.println("Enter the position of the collaborator.");
        String positionCollaborator = sc.nextLine();

        System.out.println("Enter the name of the Collaborator or worker");
        String name = sc.nextLine();

        System.out.println("1. Collaborato or 2. Worker");
        int collaborator = sc.nextInt();

		if (controllerGreen.registerKnowledgeUnitCollaborator(type,identifier,description,learnedLessons, positionCollaborator,name, collaborator, projects-1, stages-1)==true){
			System.out.println("registered capsule.");
		}else{
			System.out.println("Memory full, can not register the capsule");
		}
	}
    public void showAllKnowledgeUnits() {
        String consulta = controllerGreen.getAllKnowledgeUnits();
        if (consulta.equals(" ")){
            System.out.println("There are no registered capsules");
        }else{
            System.out.println(consulta);
        }
    }
    public void capsuleRegisterforCollaborator() {
        sc.nextLine();
        System.out.println("Enter the name.");
        String name = sc.nextLine();
        String consultCollaborator = controllerGreen.getAllKnowledgeUnitsforCollaborator(name);
        if (consultCollaborator.equals(" ")){
            System.out.println("He not registered capsules");
        }else{
            System.out.println(consultCollaborator);
        }
    }
    private void approveKnowledgeUnit() {
        System.out.println("to which project do you want see");
        String ConsultaProyectos = controllerGreen.getAllProtject();
        System.out.println("Projects: ");
        System.out.println(ConsultaProyectos);
        int project = sc.nextInt();
        System.out.println("to which Stages do you want see");
        System.out.println("Stages: ");
        String ConsultaEtapas = controllerGreen.getAllStages(project-1);
        System.out.println(ConsultaEtapas);
        int stages = sc.nextInt();
        String consulta = controllerGreen.getAproveKnowledgeUnits(project-1, stages-1);
		if(consulta.equals("")){
            System.out.println("There are no registered capsules.");
        }else{
			System.out.println("These are the registered capsules.");
            System.out.println(consulta);
            System.out.println("¿Which capsule wants to change the state?");
            int units = sc.nextInt();
			sc.nextLine();
            System.out.println("Type the status of the capsule. (1. Aproved )");
            int status = sc.nextInt(); 
            controllerGreen.approveKnowledgeUnit(project-1, stages-1, status-1, units-1);
            System.out.println("You have successfully registered.");

		}
    }
    public void showLessons() {
    System.out.println("to which Stages do you want to see");
    System.out.println("1. experiencia 2. dominio 3. gestion 4. tecnico   ");
    int stages = sc.nextInt();
    String showlessons = controllerGreen.showLessons(stages);
    System.out.println("Lessons learned: ");
    System.out.println(showlessons);
    
    }
  public void publishCapsule() {
    
    System.out.println("to which project do you want to see");
    String ConsultaProyectos = controllerGreen.getAllProtject();
    System.out.println("Projects: ");
    System.out.println(ConsultaProyectos);
    int project = sc.nextInt();
    System.out.println("to which Stages do you want to see");
    System.out.println("Stages: ");
    String ConsultaEtapas = controllerGreen.getAllStages(project-1);
    System.out.println(ConsultaEtapas);
    int stages = sc.nextInt();

    String publish = controllerGreen.showCapsulePublish(project-1,stages-1);
		if(publish.equals("")){
            System.out.println("There are no registered capsules.");
        }else{
			System.out.println("These are the registered capsules.");
            System.out.println(publish);
            System.out.println("¿Which capsule wants to change the state?");
            int units = sc.nextInt();
			sc.nextLine();
            System.out.println("Enter the status of the capsule. (1. Publish)");
            int status = sc.nextInt(); 
            controllerGreen.publish(project-1,stages-1,status-1, units-1);;
            System.out.println("You have successfully publish.");

		}

  }
}