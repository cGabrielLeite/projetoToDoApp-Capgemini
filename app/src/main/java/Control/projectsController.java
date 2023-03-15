/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Projects;
import Utility.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Gabriel
 */
public class projectsController {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public void save(Projects project) {

        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "creationDate, "
                + "updateDate) VALUES (?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreationDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar projeto.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement);
        }

    }

    public void update(Projects project) {

        String sql = "UPDATE projects SET name = ?, "
                + "description = ?, "
                + "creationDate = ?, "
                + "updateDate = ? WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreationDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar projeto.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement);
        }

    }

    public void removeById(int id) {
        String sql = "DELETE FROM projects WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar projeto.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement);
        }
    }

    public List<Projects> getAll() {

        String sql = "SELECT * FROM projects";

        List<Projects> projectList = new ArrayList();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Projects project = new Projects();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreationDate(resultSet.getDate("creationDate"));
                project.setUpdateDate(resultSet.getDate("updateDate"));
                projectList.add(project);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao carregar projetos.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement, resultSet);
        }
        return projectList;
    }

}
