public class FinalPrep {
    public static void main(String[] args) {
        
        Browsers brave = new Browsers("Brave", "Browser", 2, 4, 5, "Chromium", "Brave.Inc");
    }

    class PrivacyTools {

        private String name;
        private String type;
        private int difficulty;
        private int anonymity;
        private int practicality;

        PrivacyTools(String name, String type, int difficulty, int anonymity, int practicality) {
            this.name = name;
            this.type = type;
            this.difficulty = difficulty;
            this.anonymity = anonymity;
            this.practicality = practicality;
        }

        @Override
        public String toString() {
            return "Privacy Rating" + "\nName: " + name + "\nType: " + type + "\nDifficulty: " + difficulty
            + "\nAnonymity: " + anonymity + "\nPracticality: " + practicality;
        }
    }

    class Browsers extends PrivacyTools {

        private String build;
        private String dev;

        Browsers(String name, String type, int difficulty, int anonymity, int practicality, String build, String dev) {

            super(name, type, difficulty, anonymity, practicality);
            this.build = build;
            this.dev = dev;
        }

        public String getBuild() {
            return build;
        }

        public String getDev() {
            return dev;
        }

        @Override
        public String toString() {
            return super.toString() + "Browser Stats\n" + "Build: " + build + "\n" + "Dev: " + dev; 
        }
    }

    class Proton extends PrivacyTools {

    }

    class ProtonMail extends Proton {

    }

    class ProtonDrive extends Proton {

    }
}
