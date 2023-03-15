/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Tasks;
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
public class tasksController {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    ;
    
    public void save(Tasks task) {

        String sql = "INSERT INTO tasks (idProject, "
                + "name, "
                + "description, "
                + "isCompleted, "
                + "notes, "
                + "deadline, "
                + "creationDate, "
                + "updateDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreationDate().getTime()));
            statement.setDate(8, new Date(task.getUpdateDate().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar tarefa.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement);
        }

    }

    public void update(Tasks task) {

        String sql = "UPDATE tasks SET idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "isCompleted = ?, "
                + "notes = ?, "
                + "deadline = ?, "
                + "creationDate = ?, "
                + "updateDate = ? WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreationDate().getTime()));
            statement.setDate(8, new Date(task.getUpdateDate().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar tarefa.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement);
        }

    }

    public void removeById(int id) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar tarefa.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement);
        }
    }

    public List<Tasks> getAll(int idProject) {

        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        List<Tasks> tasksList = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Tasks task = new Tasks();
                task.setIdProject(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("isCompleted"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreationDate(resultSet.getDate("creationDate"));
                task.setUpdateDate(resultSet.getDate("updateDate"));
                tasksList.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao carregar tarefas.", ex);
        } finally {
            ConnectionFactory.closeAll(connection, statement, resultSet);
        }
        return tasksList;
    }

}
