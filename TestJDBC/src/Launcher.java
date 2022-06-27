	
        import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import java.util.ArrayList;
		import java.util.Iterator;
		import java.util.List;

public class Launcher {
	
			public static void main(String[] args) {
				
				String url = "jdbc:postgresql://localhost/biblio";
				String user = "postgres";
				String password = "lessteven";
				
				Connection con = null;
				Statement sta = null;
				ResultSet rs = null;
				
				//Lister les auteurs 
				List<Auteur> listeAuteurs = new ArrayList<Auteur>();
				try {
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection(url, user, password);
					  sta=con.createStatement();
					  String query = "Select * FROM auteur";
					  rs = sta.executeQuery(query);
					  while(rs.next()) {
						  String nom = rs.getString("nom");
						  String prenom = rs.getString("prenom");
						  System.out.println(nom + prenom);
					  }
					  
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						rs.close();
						sta.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("-------------------");
				
				//Récupérer un auteur à partir d'un ID
				Auteur auteur = new Auteur();
				try {
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection(url, user, password);
					  sta=con.createStatement();
					  String query = "Select * FROM auteur where id = 2";
					  rs = sta.executeQuery(query);
					  if(rs.next()) {
						  String nom = rs.getString("nom");
						  String prenom = rs.getString("prenom");
						  System.out.println(nom + prenom);
					  }
					  
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						rs.close();
						sta.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
				
				System.out.println("-------------------");
				
				//Ajouter un auteur
				auteur = new Auteur("Toto", "Tata", "0660606060", "toto@tata.fr");
				try {
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection(url, user, password);
					  sta=con.createStatement();
			          String query = "INSERT INTO auteur(nom, prenom, telephone, email) VALUES ('ToTo','Tata', '066060606','toto@tata.fr')";
					  sta.executeUpdate(query);
					  
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						
						sta.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
				System.out.println("-------------------");
				
				//Modifier un auteur
				try {
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection(url, user, password);
					  sta = con.createStatement();
					  String query = "UPDATE auteur SET nom='toi',prenom='moi',telephone='1' WHERE ID = 10 ";
					  sta.executeUpdate(query);	  
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						sta.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
				System.out.println("-------------------");
				
				//Supprimer un auteur
				try {
					  Class.forName("org.postgresql.Driver");
					  con = DriverManager.getConnection(url, user, password);
					  sta=con.createStatement();
					  String query= "DELETE FROM auteur WHERE id = 9 ";
					  sta.executeUpdate(query);
					  
			    } catch(SQLException ex) {
			    	ex.printStackTrace();
			    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						sta.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
			}

		
		// TODO Auto-generated method stub

	}


