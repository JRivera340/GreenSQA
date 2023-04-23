package model;
import java.util.Calendar;

public class ProjectGreen {
    private String nameProject;
	private String nameCostumer;
	private String nameManager;
	private Calendar startDate;
	private Calendar endDate;
    private int projectBudget; 
    private int managerTell;
    private int costumerTell;
    private Stage[] stages;
    /**
     * Description: Allows create a project depending the parameter and save de info of the stages.
     * @param nameProject
     * @param nameCostumer
     * @param nameManager
     * @param startDate
     * @param endDate
     * @param projectBudget
     * @param managerTell
     * @param costumerTell
     */
    public ProjectGreen(String nameProject, String nameCostumer, String nameManager, Calendar startDate, Calendar endDate, int projectBudget, int managerTell, int costumerTell) {
		this.nameProject = nameProject;
		this.nameCostumer = nameCostumer;
		this.nameManager = nameManager;
		this.startDate = startDate;
		this.endDate = endDate;
        this.projectBudget = projectBudget;
        this.managerTell = managerTell;
        this.costumerTell = costumerTell;

        stages = new Stage[6];
        SixStages(startDate, endDate);
        
	}
    /**
     * Description: Allows create the stages when create a new project
     * @param initialDateP
     * @param finalDateP
     */
    public void SixStages(Calendar initialDateP,Calendar finalDateP) {
        stages[0] = new Stage(initialDateP, finalDateP, TypeStage.INCIO, true);
        stages[0].setInitialDateR();
        stages[1] = new Stage(initialDateP, finalDateP, TypeStage.ANALISIS, false);
        stages[2] = new Stage(initialDateP, finalDateP, TypeStage.DISEÑO, false);
        stages[3] = new Stage(initialDateP, finalDateP, TypeStage.EJECUCION, false);
        stages[4] = new Stage(initialDateP, finalDateP, TypeStage.CIERRE_Y_SEGUIMIENTO, false);
        stages[5] = new Stage(initialDateP, finalDateP, TypeStage.CONTROL_DEL_PROYECTO, false);
	}
    
    public String getNameProject() {
		return nameProject;
	}

    public String getNameCostumer() {
		return nameCostumer;
	}

    public String getNameManager() {
		return nameManager;
	}

    public Calendar getStartDate() {
		return startDate;
	}

    public Calendar getEndDate() {
		return endDate;
	}

    public int getProjectBudget() {
		return projectBudget;
	}

    public int getManagerTell() {
		return managerTell;
	}

    public int getCostumerTell() {
		return costumerTell;
	}

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public void setNameCostumer(String nameCostumer) {
        this.nameCostumer = nameCostumer;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

    public void setManagerTell(int managerTell) {
        this.managerTell = managerTell;
    }

    public void setCostumerTell(int costumerTell) {
        this.costumerTell = costumerTell;
    }
    public Stage[] getStages() {
        return stages;
    }
    public void setStages(Stage[] stages) {
        this.stages = stages;
    }
    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }
}

