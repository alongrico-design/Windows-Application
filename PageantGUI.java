import javax.swing.*;
public class PageantGUI {
        
    
    public static void main(String[] args) {
        
        int num = Integer.parseInt(
            JOptionPane.showInputDialog("Enter number of candidates: ")); // NUMBER OF CANDIDATES
        float[][] scores = new float[num][4];
        int currentCandidate = 0;
        
        
        JFrame frame = new JFrame("Pageant System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // important for manual positioning
        
        JLabel title = new JLabel("PAGEANT SCORING SYSTEM", SwingConstants.CENTER);
        title.setBounds(50, 10, 400, 40);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        frame.add(title);
        
        //CANDIDATE SELECTOR
        JComboBox<String> candidateBox = new JComboBox<>();
        for (int i = 1; i <= num; i++) {
            candidateBox.addItem("Candidate " + i);
        }

        candidateBox.setBounds(150, 50, 200, 30);
        frame.add(candidateBox);
        
        
        
        //GOWN BUTTON nako ni
        JButton gownBtn = new JButton("Evening Gown");
        gownBtn.setBounds(150, 80, 200, 30);
        frame.add(gownBtn);

        gownBtn.addActionListener(e -> {

            int index = candidateBox.getSelectedIndex();
            
            String elegance = JOptionPane.showInputDialog("Rate Elegance (1-10):");
            if (elegance == null) return; // PARA NI MA X OR MA-CANCEL ANG INPUT DIALOUGE NGA DILI NA MO PROCEED 
            String gown = JOptionPane.showInputDialog("Rate Gown (1-10):");
            if (gown == null) return;
            String presence = JOptionPane.showInputDialog("Rate Stage Presence (1-10):");
            if (presence == null) return;

            int el = Integer.parseInt(elegance);
            int go = Integer.parseInt(gown);
            int pr = Integer.parseInt(presence);

            float result = (el * 0.4f) + (go * 0.3f) + (pr * 0.3f);

            scores[index][0] = result; // SAVE SCORE HERE
            
            JOptionPane.showMessageDialog(frame,
                "Saved for Candidate " + (index + 1) + "\nScore: " + result);
        });        
        
        //CREATIVE ATTIRE BUTTON
        JButton creativeBtn = new JButton("Creative Attire");
        creativeBtn.setBounds(150, 130, 200, 30);
        frame.add(creativeBtn);
        
        creativeBtn.addActionListener(e -> {

            int index = candidateBox.getSelectedIndex();
            
            String creativity = JOptionPane.showInputDialog("Rate Creativity (1-10):");
            if (creativity == null) return;
            String design = JOptionPane.showInputDialog("Rate Design (1-10):");
            if (design == null) return;
            String presence = JOptionPane.showInputDialog("Rate Stage Presence (1-10):");
            if (presence == null) return;

            int cr = Integer.parseInt(creativity);
            int de = Integer.parseInt(design);
            int pr = Integer.parseInt(presence);

            float result = (cr * 0.3f) + (de * 0.4f) + (pr * 0.3f);
            
            scores[index][1] = result;
            
            JOptionPane.showMessageDialog(frame,
            "Saved Creative Score for Candidate " + (index + 1) +
            "\nScore: " + result);
        });

        
        //TALENT PORTION BUTTON
        JButton talentBtn = new JButton("Talent");
        talentBtn.setBounds(150, 180, 200, 30);
        frame.add(talentBtn);

        talentBtn.addActionListener (e -> { 
            
            int index = candidateBox.getSelectedIndex();
            
            String talent = JOptionPane.showInputDialog("Rate Talent/Skill (1 - 10)");
            if (talent == null) return;
            String performance = JOptionPane.showInputDialog("Rate Performance (1 - 10)");
            if (performance == null) return;
            String presence = JOptionPane.showInputDialog("Rate Stage Presence (1 - 10)");
            if (presence == null) return;
            
            int tal = Integer.parseInt(talent);
            int per = Integer.parseInt(performance);
            int pres = Integer.parseInt(presence);
            
            float result = (tal * 0.3f) + (per * 0.4f) + (pres * 0.3f);
            
            scores[index][2] = result;
            
            JOptionPane.showMessageDialog(frame,
                "Saved Talent Score for Candidate " + (index + 1) +
                "\nScore: " + result);
        
        });
        
        
        
        
        //Q&A BUTTON
        JButton qaBtn = new JButton("Q&A");
        qaBtn.setBounds(150, 230, 200, 30);
        frame.add(qaBtn);
        
        qaBtn.addActionListener (e -> { 
            
            int index = candidateBox.getSelectedIndex();
            
            String content = JOptionPane.showInputDialog("Rate Content of Message (1 - 10)");
            if (content == null) return;
            String delivery = JOptionPane.showInputDialog("Rate Delivery (1 - 10)");
            if (delivery == null) return;
            String confidence = JOptionPane.showInputDialog("Rate Confidence (1 - 10)");
            if (confidence == null) return;
            
            int con = Integer.parseInt(content);
            int del = Integer.parseInt(delivery);
            int confi = Integer.parseInt(confidence);
            
            float result = (con * 0.3f) + (del * 0.4f) + (confi * 0.3f);
            
            scores[index][3] = result;

            JOptionPane.showMessageDialog(frame,
                "Saved Q&A Score for Candidate " + (index + 1) +
                "\nScore: " + result);
        
        });        
            
            
            //RESULTS OR WINNER DISPLAY
            JButton resultBtn = new JButton("Show Winners");
            resultBtn.setBounds(150, 280, 200, 30);
            frame.add(resultBtn);

            resultBtn.addActionListener(e -> {
            
                
            boolean hasScore = false;

                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (scores[i][j] != 0) {
                            hasScore = true;
                            break;
                        }
                    }
                    if (hasScore) break;
                }

                if (!hasScore) {
                    JOptionPane.showMessageDialog(frame, "You haven't judged yet.");
                    return; 
                }    
            

            int gownWinner = 0;
            int creativeWinner = 0;
            int talentWinner = 0;
            int qaWinner = 0;
            int overallWinner = 0;

            for (int i = 1; i < num; i++) {

                if (scores[i][0] > scores[gownWinner][0]) gownWinner = i;
                if (scores[i][1] > scores[creativeWinner][1]) creativeWinner = i;
                if (scores[i][2] > scores[talentWinner][2]) talentWinner = i;
                if (scores[i][3] > scores[qaWinner][3]) qaWinner = i;

                float totalI =
                    scores[i][0] + scores[i][1] + scores[i][2] + scores[i][3];

                float totalW =
                    scores[overallWinner][0] + scores[overallWinner][1] +
                    scores[overallWinner][2] + scores[overallWinner][3];

                if (totalI > totalW) overallWinner = i;
            }

            boolean gownJudged = false;
            boolean creativeJudged = false;
            boolean talentJudged = false;
            boolean qaJudged = false;

            for (int i = 0; i < num; i++) {
                if (scores[i][0] != 0) gownJudged = true;
                if (scores[i][1] != 0) creativeJudged = true;
                if (scores[i][2] != 0) talentJudged = true;
                if (scores[i][3] != 0) qaJudged = true;
            }
            
            String gownText = gownJudged 
                ? "Candidate " + (gownWinner + 1) 
                : "Not judged yet";

            String creativeText = creativeJudged 
                ? "Candidate " + (creativeWinner + 1) 
                : "Not judged yet";

            String talentText = talentJudged 
                ? "Candidate " + (talentWinner + 1) 
                : "Not judged yet";

            String qaText = qaJudged 
                ? "Candidate " + (qaWinner + 1) 
                : "Not judged yet";
            
            JOptionPane.showMessageDialog(frame,
                "🏆 WINNERS 🏆\n\n" +
                "Evening Gown: " + gownText + "\n" +
                "Creative: " + creativeText + "\n" +
                "Talent: " + talentText + "\n" +
                "Q&A: " + qaText + "\n\n" +
                "👑 OVERALL WINNER: Candidate " + (overallWinner + 1)
            );
            
            
        });
        
        frame.setVisible(true);
    
}
    
    
    
}
