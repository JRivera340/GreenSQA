package model;

public class KnowledgeGreen {
	private StatusPublication statusPublication;
    private String identifier;
	private String description;
	private TypeKnowledge type;
	private String learnedLessons;
    private String positionCollaborator;
    private String nameCollaborator;
	private StatusKnowledgeUnits status;
    private CollaboratorGreen typeAssistant;
	
	
	/**
	 * Description: Allows create a Knoledge Units and almacenate the info depending by the parameters
	 * @param identifier
	 * @param description
	 * @param type
	 * @param learnedLessons
	 * @param positionCollaborator
	 * @param nameCollaborator
	 * @param typeAssistant
	 */
	public KnowledgeGreen(String identifier, String description, TypeKnowledge type, String learnedLessons, String positionCollaborator, String nameCollaborator, CollaboratorGreen typeAssistant) {

		this.statusPublication = StatusPublication.PUBLISH_PENDING;
		this.identifier = identifier;
		this.description = description;
		this.type = type; 
		this.learnedLessons = learnedLessons;
        this.positionCollaborator = positionCollaborator;
        this.nameCollaborator = nameCollaborator;
		this.status = StatusKnowledgeUnits.POR_DEFINIR;
        this.typeAssistant = typeAssistant;
		
	}
	
    public CollaboratorGreen getTypeAssistant() {
		return typeAssistant;
	}
    public void setTypeAssistant(CollaboratorGreen typeAssistant) {
        this.typeAssistant = typeAssistant;
    }
	public String getIdentifier() {
		return identifier;
	}

	public void setId(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeKnowledge getType() {
		return type;
	}

	public void setType(TypeKnowledge type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	public StatusKnowledgeUnits getStatus(){
		return status;
	}
	public void setStatus(StatusKnowledgeUnits status){
		this.status = status;
	}
    public void setPositionCollaborator(String positionCollaborator) {
        this.positionCollaborator = positionCollaborator;
    }
    public String getPositionCollaborator() {
        return positionCollaborator;
    }
    public void setNameCollaborator(String nameCollaborator) {
        this.nameCollaborator = nameCollaborator;
    }
    public String getNameCollaborator() {
        return nameCollaborator;
    }
	public StatusPublication getStatusPublication() {
		return statusPublication;
	}
    public void setStatusPublication(StatusPublication statusPublication) {
		this.statusPublication = statusPublication;
    }

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
