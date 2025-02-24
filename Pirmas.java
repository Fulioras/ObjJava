public class Pirmas {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Naudojimas: java Pirmas <eilutes_ilgis> <tekstas>");
            return;
        }

        int lineLength;
        try {
            lineLength = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Pirmas argumentas privalo buti sveikas skaicius");
            return;
        }

        StringBuffer text = new StringBuffer();
        for (int i = 1; i < args.length; i++) {
            text.append(args[i]).append(" ");
        }

        String cleanedText = text.toString().replaceAll("\\s+", " ").trim();

        StringBuffer formattedText = new StringBuffer();
        int count = 0;

        for (String word : cleanedText.split(" ")) {
            if (count + word.length() > lineLength) {
                formattedText.append("\n");
                count = 0;
            }
            formattedText.append(word).append(" ");
            count += word.length() + 1;
        }

        System.out.println(formattedText.toString().trim());
    }
}
