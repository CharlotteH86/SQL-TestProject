package beans;

/*public class Bean {

	private String merchantName, merchantPhone;

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

}*/
public class Bean {

	private String bearName, origin, notes, creator;

	private String ikeaName, description, columnThree, columnFour, columnFive;
	
	
	//KOMMENTAR TILL MARCUS! Troligtvis gjort fel här gällande float och int variabler. Ge gärna feedback på vad som kan göras bättre SAMT på hur jag kan strukturera min bean på ett sätt så det lever upp till kraven på att klara båda kurserna. 
	
	private float rating, SCP;
	
	
	private int id, animal, autonomous, cognitohazard, computer, extradimensional, humanoid, structure;
	
	private String  Title, Classification, Type, Related_GOI_s, Location_Notes, Author, Leaked_info,   Artifact_Location_or_Sentient,  Summary, Gender, Ethnicity_Origins;

	private String defaultValue;
	//private String id, SCP, Title, rating, Classification, Type, Related_GOI_s, Location_Notes, Author, Leaked_info, humanoid, structure, animal, computer, autonomous, cognitohazard, Artifact_Location_or_Sentient, extradimensional, Summary, Gender, Ethnicity_Origins;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public int getAutonomous() {
		return autonomous;
	}

	public void setAutonomous(int autonomous) {
		this.autonomous = autonomous;
	}

	public int getCognitohazard() {
		return cognitohazard;
	}

	public void setCognitohazard(int cognitohazard) {
		this.cognitohazard = cognitohazard;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public int getExtradimensional() {
		return extradimensional;
	}

	public void setExtradimensional(int extradimensional) {
		this.extradimensional = extradimensional;
	}

	public int getHumanoid() {
		return humanoid;
	}

	public void setHumanoid(int humanoid) {
		this.humanoid = humanoid;
	}

	public int getStructure() {
		return structure;
	}

	public void setStructure(int structure) {
		this.structure = structure;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getSCP() {
		return SCP;
	}

	public void setSCP(float SCP) {
		this.SCP = SCP;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getClassification() {
		return Classification;
	}

	public void setClassification(String classification) {
		Classification = classification;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getRelated_GOI_s() {
		return Related_GOI_s;
	}

	public void setRelated_GOI_s(String related_GOI_s) {
		Related_GOI_s = related_GOI_s;
	}

	public String getLocation_Notes() {
		return Location_Notes;
	}

	public void setLocation_Notes(String location_Notes) {
		Location_Notes = location_Notes;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getLeaked_info() {
		return Leaked_info;
	}

	public void setLeaked_info(String leaked_info) {
		Leaked_info = leaked_info;
	}

	public String getArtifact_Location_or_Sentient() {
		return Artifact_Location_or_Sentient;
	}

	public void setArtifact_Location_or_Sentient(String artifact_Location_or_Sentient) {
		Artifact_Location_or_Sentient = artifact_Location_or_Sentient;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEthnicity_Origins() {
		return Ethnicity_Origins;
	}

	public void setEthnicity_Origins(String ethnicity_Origins) {
		Ethnicity_Origins = ethnicity_Origins;
	}



	public String getBearName() {
		return bearName;
	}

	public void setBearName(String bearName) {
		this.bearName = bearName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getIkeaName() {
		return ikeaName;
	}

	public void setIkeaName(String ikeaName) {
		this.ikeaName = ikeaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColumnThree() {
		return columnThree;
	}

	public void setColumnThree(String columnThree) {
		this.columnThree = columnThree;
	}

	public String getColumnFour() {
		return columnFour;
	}

	public void setColumnFour(String columnFour) {
		this.columnFour = columnFour;
	}

	public String getColumnFive() {
		return columnFive;
	}

	public void setColumnFive(String columnFive) {
		this.columnFive = columnFive;
	}

	
	
	
	//Ignorera nedan kod.
	/*@Override
	public String toString() {
		return "Bean [bearName=" + bearName + ", origin=" + origin + ", notes=" + notes + ", creator=" + creator
				+ ", ikeaName=" + ikeaName + ", description=" + description + ", columnThree=" + columnThree
				+ ", columnFour=" + columnFour + ", columnFive=" + columnFive + ", rating=" + rating + ", SCP=" + SCP
				+ ", id=" + id + ", animal=" + animal + ", autonomous=" + autonomous + ", cognitohazard="
				+ cognitohazard + ", computer=" + computer + ", extradimensional=" + extradimensional + ", humanoid="
				+ humanoid + ", structure=" + structure + ", Title=" + Title + ", Classification=" + Classification
				+ ", Type=" + Type + ", Related_GOI_s=" + Related_GOI_s + ", Location_Notes=" + Location_Notes
				+ ", Author=" + Author + ", Leaked_info=" + Leaked_info + ", Artifact_Location_or_Sentient="
				+ Artifact_Location_or_Sentient + ", Summary=" + Summary + ", Gender=" + Gender + ", Ethnicity_Origins="
				+ Ethnicity_Origins + ", defaultValue=" + defaultValue + "]";
	}*/
	
	



}

/*
public class Bean {

	private String bearName, origin, notes, creator;

	public String getBearName() {
		return bearName;
	}

	public void setBearName(String bearName) {
		this.bearName = bearName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}



}*/

/*
public class Bean {

	private String bearName, origin;

	public String getBearName() {
		return bearName;
	}

	public void setBearName(String bearName) {
		this.bearName = bearName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
}*/