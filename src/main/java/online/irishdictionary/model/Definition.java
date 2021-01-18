package online.irishdictionary.model;

//public class Definition {
public class Definition implements Cloneable {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private int id = -1;
    private String word = null;
    private String wordAscii = null;
    private String definition = null;
    private String type = null;           // n, adj, adv, vi, vt, npl (verb, noun, adverb, pronoun, preposition and conjuction!)
    private String description = null;
    private String gender = null;         // m1. m2, m3, m4, f1, f2, f3, f4, mpl1, fpl2

    public Definition() {}
    
    public Definition(String definition) {
        this.definition = definition;
    }

    @Override
    public Object clone() {
        try {
            return (Definition) super.clone();
        } catch (CloneNotSupportedException e) {
            //return new Definition(this.definition);
            log.error(e.getMessage(), e);
            return null;F
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    public void setWordAscii(String wordAscii) {
        this.wordAscii = wordAscii;
    }

    public String getWordAscii() {
        return this.wordAscii;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinition() {
        return this.definition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDefinitionWildCarded() {
        if(definition != null) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < definition.length(); i++){
                sb.append("%");
                sb.append(definition.charAt(i));
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getDefinitionWildCardedNoH() {
        if(definition != null) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < definition.length(); i++){
                sb.append("%");
                if(definition.charAt(i) != 'h') {
                    sb.append(definition.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getDefinitionWildCardedEverSecondLetter() {
        if(definition != null) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < definition.length(); i++){
                sb.append("%");
                if((i % 2) == 0) {
                    sb.append(definition.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getDefinitionWildCardedEverSecondLetter2() {
        if(definition != null) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < definition.length(); i++){
                sb.append("%");
                if((i % 2) == 1) {
                    sb.append(definition.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getWhereDefinitionLikeSQL() {

        if(this.definition.length() == 1) {
        } else if(this.definition.length() == 2) {
        } else if(this.definition.length() == 3) {
        } else if(this.definition.length() == 4) {
        } else if(this.definition.length() == 5) {
        } else if(this.definition.length() >= 6) {
        }

        StringBuffer sb = new StringBuffer();
        sb.append("where definition like '");
        sb.append(getDefinitionWildCarded());
        sb.append("' ");
        sb.append("or definition like '");
        sb.append(getDefinitionWildCardedNoH());
        sb.append("' ");
        sb.append("or definition like '");
        sb.append(getDefinitionWildCardedEverSecondLetter());
        sb.append("' ");
        //sb.append("or definition like '");
        //sb.append(getDefinitionWildCardedEverSecondLetter2());
        //sb.append("'");
        return sb.toString();
    }

    public String toString() {
        return new StringBuilder().append("Definition{").append(this.word).append(":").append(this.definition).append("}").toString();
    }
}
