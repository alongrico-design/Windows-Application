
package pageant;

import java.util.*;
public class Pageant {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean k = true;
        
        //Settings
        System.out.println("======WELCOME======");
        System.out.println("Input the number of candidates: ");
        int num = sc.nextInt();
        
        //Arrays: Where I save the score data of each candidates
        String [] candidates = new String[num];
        float [][] scores = new float[num][4];
        boolean[] judged = new boolean[4]; // kani nga array is para mo check kung na gamit ba ang isa ka category

            
            
        
        while (k){
        //Option Settings    
        System.out.println("=====PAGEANT SCORER=====");
        

        
        System.out.println("");
        System.out.println("NOTE: Please select the category to judge. (Number only)");
        System.out.println("[1]Evening Gown Attire");
        System.out.println("[2]Creative Attire");
        System.out.println("[3]Talent Portion");
        System.out.println("[4]Q&A");
        System.out.println("");
        System.out.println("==SELECTION==");
        int choose = sc.nextInt();
        
        
        if (choose == 1){
            System.out.println("=====Welcome to Evening Gown phase! Please input your given score.=====");
            System.out.println("");
            
            
            System.out.println("=====Evening Gown Judging=====");

            for (int i = 0; i < num; i++) {
                System.out.println("Judging Candidate " + (i + 1));
                scores[i][0] = EveGown(sc);
            }
        
            judged[0] = true;
            
            
            
        }
        
        else if (choose == 2){
            System.out.println("Welcome to Creative Attire phase! Please input your given score.");
            
            System.out.println("");

            
            
            System.out.println("=====Creative Attire Judging=====");

            for (int i = 0; i < num; i++) {
                System.out.println("Judging Candidate " + (i + 1));
                scores[i][1] = CreAtt(sc);
            }
            
            judged[1] = true;
            
            
        }
        
        else if (choose == 3){
            System.out.println("Welcome to Talent Portion Phase! Please input your given score.");
            
            System.out.println("");

            
            System.out.println("=====Talent Portion Judging=====");

            for (int i = 0; i < num; i++) {
                System.out.println("Judging Candidate " + (i + 1));
                scores[i][2] = TalPor(sc);
            }
            
            judged[2] = true;
            
            
        }
        
        else if (choose == 4){
            System.out.println("Welcome to Q&A Phase! Please input your given score.");

            System.out.println("");

            
            System.out.println("=====Q&A Judging=====");

            for (int i = 0; i < num; i++) {
                System.out.println("Judging Candidate " + (i + 1));
                scores[i][3] = QA(sc);
            }
            
            judged[3] = true;
        
        }else {
            System.out.println("Invalid input!");
            System.out.println("=========ERROR==========");
        
        }
        
            System.out.println("Do you want to leave? [1]Yes [2]No");
            int exit = sc.nextInt();
            
            
            
            
            
            //Computation of overall winners and category winners
            if (exit == 1){
                
                            // ===== CATEGORY WINNERS =====

                
                            
// Evening Gown
                    
                if (judged[0]) {
                    int gownWinner = 0;
                    for (int i = 1; i < num; i++) {
                        if (scores[i][0] > scores[gownWinner][0]) {
                            gownWinner = i;
                        }
                    }
                    System.out.println("Evening Gown Winner: Candidate " + (gownWinner + 1));

                } else {
                    System.out.println("Evening Gown not judged yet.");
                }


                // Creative

                if (judged[1]) {
                int creativeWinner = 0;
                    for (int i = 1; i < num; i++) {
                        if (scores[i][1] > scores[creativeWinner][1]) {
                            creativeWinner = i;
                        }
                    }
                    System.out.println("Creative Winner: Candidate " + (creativeWinner + 1));
                } else {
                   System.out.println("Creative not judged yet.");
               }

                
                // Talent
                
                if (judged[2]) {
                    int talentWinner = 0;
                    for (int i = 1; i < num; i++) {
                        if (scores[i][2] > scores[talentWinner][2]) {
                            talentWinner = i;
                        }
                    }
                    System.out.println("Talent Winner: Candidate " + (talentWinner + 1));
                } else {
                   System.out.println("Talent Portion not judged yet.");
               }
                

                // Q&A
                
                if (judged[3]) {
                    int qaWinner = 0;
                    for (int i = 1; i < num; i++) {
                        if (scores[i][3] > scores[qaWinner][3]) {
                            qaWinner = i;
                        }
                    }
                    System.out.println("Q&A Winner: Candidate " + (qaWinner + 1));
                } else {
                   System.out.println("Q&A not judged yet.");
               }
                
                
                // ===== OVERALL WINNER =====

                int overallWinner = 0;
                for (int i = 1; i < num; i++) {

                    float totalI = scores[i][0] + scores[i][1] + scores[i][2] + scores[i][3];
                    float totalW = scores[overallWinner][0] + scores[overallWinner][1] + scores[overallWinner][2] + scores[overallWinner][3];

                    if (totalI > totalW) {
                        overallWinner = i;
                    }
                }
                
                System.out.println("");
                System.out.println("");
                System.out.println("OVERALL WINNER: Candidate " + (overallWinner + 1));


                
                
                k = false;
            
            }
        
        
        
        }
        
    }//End of Main parameter
    
    
    
    public static float EveGown(Scanner sc){
        System.out.println(""); 
        System.out.println("=====JUDGE TIME=====");
        System.out.println("Input each of judging score.");
        System.out.println("NOTE: The score must be 1 - 10. Put number only...");
        
        //Space portion
        System.out.println("");
        System.out.println("");
        
        //Judging portion
        
        int elegance;
        do{
            System.out.println("Rate for Elegance: ");
            elegance = sc.nextInt();        
        } while (elegance < 1 || elegance > 10);
        
        int gown;
        do {
            System.out.println("Rate for Gown and Overall Appearance: ");
            gown = sc.nextInt();
        } while (gown < 1 || gown > 10);
        
        int presence;
        do {
            System.out.println("Rate for Stage Presence: ");
            presence = sc.nextInt();
        } while (presence < 1 || presence > 10);
        
        //Compute of overall score
        float fin = (elegance * 0.4f) + (gown * 0.3f) + (presence * 0.3f);
        System.out.println("");
        System.out.println("=====THE FINAL RESULT=====");
        System.out.println("Result: "+ fin);
        
        return fin;
    
    }
    
    public static float CreAtt(Scanner sc){
        System.out.println("");
        System.out.println("=====JUDGE TIME=====");
        System.out.println("Input each of judging score.");
        System.out.println("NOTE: The score must be 1 - 10. Put number only...");
        
        //Space portion
        System.out.println("");
        System.out.println("");
        
        //Judging portion
        int creat;
        do {
            System.out.println("Rate for Creativity: ");
            creat = sc.nextInt();
        } while (creat < 1 || creat > 10);
        
        int design;
        do {
            System.out.println("Rate for Design: ");
            design = sc.nextInt();
        } while (design < 1 || design > 10);
        
        int presence;
        do {
            System.out.println("Rate for Stage Presence: ");
            presence = sc.nextInt();
        } while (presence < 1 || presence > 10);
        
        //Compute of overall score
        float fin = (creat * 0.3f) + (design * 0.4f) + (presence * 0.3f);
        System.out.println("");
        System.out.println("=====THE FINAL RESULT=====");
        System.out.println("Result: "+ fin);    
        
        return fin;
    
    }
    
    public static float TalPor(Scanner sc){
        System.out.println("");
        System.out.println("=====JUDGE TIME=====");
        System.out.println("Input each of judging score.");
        System.out.println("NOTE: The score must be 1 - 10. Put number only...");
        
        //Space portion
        System.out.println("");
        System.out.println("");
        
        //Judging portion
        int tal;
        do {
            System.out.println("Rate for Talent/Skill Level: ");
            tal = sc.nextInt();
        } while (tal < 1 || tal > 10);    
        
        int exe;
        do {
            System.out.println("Rate for Performance/Execution: ");
            exe = sc.nextInt();
        } while (exe < 1 || exe > 10);
        
        int presence;
        do {
            System.out.println("Rate for Stage Presence: ");
            presence = sc.nextInt();
        } while (presence < 1 || presence > 10);
            
        //Compute of overall score
        float fin = (tal * 0.4f) + (exe * 0.4f) + (presence * 0.2f);
        System.out.println("");
        System.out.println("=====THE FINAL RESULT=====");
        System.out.println("Result: "+ fin); 
        
        return fin;
    
    }
    
    public static float QA(Scanner sc){
        System.out.println("");
        System.out.println("=====JUDGE TIME=====");
        System.out.println("Input each of judging score.");
        System.out.println("NOTE: The score must be 1 - 10. Put number only...");
        
        //Space portion
        System.out.println("");
        System.out.println("");
        
        //Judging portion
        int cont;
        do {
            System.out.println("Rate for Content/Substance of Answer: ");
            cont = sc.nextInt();
        } while (cont < 1 || cont > 10);
        
        int del;
        do {
            System.out.println("Rate for Delivery: ");
            del = sc.nextInt();
        } while (del < 1 || del > 10);
        
        int confi;
        do {
            System.out.println("Rate for Confidence: ");
            confi = sc.nextInt();
        } while (confi < 1 || confi > 10);
        
        
        //Compute of overall score
        float fin = (cont * 0.4f) + (del * 0.3f) + (confi * 0.3f);
        System.out.println("");
        System.out.println("=====THE FINAL RESULT=====");
        System.out.println("Result: "+ fin);  
        
        return fin;
    
    }
    
    
}
