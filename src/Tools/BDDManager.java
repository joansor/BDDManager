package Tools;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
     Created by cladlink on 12/03/16.
     */

    public class BDDManager {

       // private final String BDD_URL = "jdbc:mysql://localhost:3306/dvdtheque";
      //  private final String BDD_USER = "root";
        //private final String BDD_PASSWORD =  "";
        private Connection connection;
        private Statement statement;


        public BDDManager(){

        }
        /**
         * start()
         * sert à initialiser la connexion à la BDD
         */
        public void start(String url, String user, String password) {
            try {
                connection = DriverManager.getConnection (url ,user, password);
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * stop()
         * Sert à rompre la connexion avec le BDD
         */
        public void stop() {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * lire()
         * permet de lire un fichier sql et de l'exécuter
         */
        public void lire(String adressSQLFile)
        {
            BufferedReader lecture;

            String fichier = "", fichierTemp;
            String[] requete;
            try
            {
                lecture = new BufferedReader(new FileReader(adressSQLFile));
                System.out.println(lecture);
                try
                {
                    while ((fichierTemp = lecture.readLine()) != null)
                    {
                        fichier += fichierTemp;
                        fichier += " ";
                    }
                    requete = fichier.split(";");
                    for (int i = 0; i<requete.length; i++) {
                        requete[i] += ";";
                        System.out.println(i);
                        System.out.println(requete[i]);
                        if (requete[i].contains("SELECT")) {

                            select(requete[i]);
// todo
                        } else if (requete[i].contains("INSERT")){
                            insert(requete[i]);

// todo
                        } else if (requete[i].contains("DELETE")){
                            delete(requete[i]);

// todo
                        } else if (requete[i].contains("UPDATE")){
                            update(requete[i]);

// todo
                        }else{
                            autreRequete(requete[i]);


                        }
                    }
                }
                catch (EOFException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        lecture.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
            catch (FileNotFoundException e)
            {
                System.err.println("le fichier est introuvable");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
        /**
         *
         * @param maRequete
         */
        public boolean autreRequete(String maRequete) {

            return tryCatch(maRequete);

        }

        /**
         *
         * @param maRequete
         */
        public boolean insert(String maRequete) {

           return tryCatch(maRequete);

        }

        /**
         *
         * @param maRequete
         */
        public ArrayList<ArrayList<String>>  select(String maRequete) {

            System.out.println(maRequete);
            ArrayList<ArrayList<String>> resultatDeLaRequete = new ArrayList<>();

            try
            {
                ResultSet rs = statement.executeQuery(maRequete); // execution de la requete de type select
                ResultSetMetaData rsmd = rs.getMetaData(); // ca rend le truc lisible
                int nbcols = rsmd.getColumnCount(); // ici on récupére le nombre de lignes

                int i=0;
                while(rs.next()) // tant qu'il y a des lignes à lire
                {
                    resultatDeLaRequete.add(new ArrayList<>()); // je crée une arraylist ...
                    for (int j = 1; j <= nbcols; j++)
                        resultatDeLaRequete.get(i).add(rs.getString(j)); // ...
                    i++;
                }
            }

            catch (SQLException e)
            {
                e.printStackTrace();
            }
            return resultatDeLaRequete;

        }

        /**
         *
         * @param maRequete
         */
        public boolean update(String maRequete) {
          return tryCatch(maRequete);
        }

        /**
         *
         * @param maRequete
         */
        public boolean delete(String maRequete) {

           return tryCatch(maRequete);

        }

        public boolean tryCatch (String maRequete){
            System.out.println(maRequete);
            try
            {
                statement.executeUpdate(maRequete);
                return true;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                return false;
            }
        }
        /**
         * main
         * ce main n'est utiliser que pour créer les tables.
         */
        public static void main(String[] args) {
            BDDManager bdd = new BDDManager();
            bdd.start("jdbc:mysql://localhost:3306/", "root", "");
            bdd.lire("src/BDD_Film.sql");
            System.out.println(bdd);
            bdd.stop();
        }

    }

