package com.meituan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.meituan.db.JdbcUtils;
import com.meituan.utils.ReflectionUtils;
import com.meituan.web.ConnectionContext;

/**
 * 封装了基本的 CRUD 的方法, 以供子类继承使用 当前 DAO 直接在方法中获取数据库连接. 整个 DAO 采取 DBUtils 解决方案.
 * 
 * @param <T>:
 *            当前 DAO 处理的实体类的类型是什么
 */
public class DAO<T>
{

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	public DAO()
	{
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	/**
	 * 返回某一个字段的值：例如返回某一条记录的 customerName, 或返回数据表中有多少条记录等.
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object... args)
	{
		Connection connection = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回 T 所对应的 List
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object... args)
	{
		Connection connection = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回对应的 T 的一个实例类的对象.
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object... args)
	{
		Connection connection = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 该方法封装了 INSERT、DELETE、UPDATE 操作.
	 * 
	 * @param sql:
	 *            SQL 语句
	 * @param args:
	 *            填充 SQL 语句的占位符.
	 */
	public void update(String sql, Object... args)
	{
		Connection connection = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			queryRunner.update(connection, sql, args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 批量处理
	public void batch(String sql, Object[]... params)
	{
		Connection connection = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			queryRunner.batch(connection, sql, params);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 插入语句返回id
	public long insert(String sql, Object... args)
	{
		long id = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (args != null)
			{
				for (int i = 0; i < args.length; i++)
				{
					preparedStatement.setObject(i + 1, args[i]);
				}
			}
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
			{
				id = resultSet.getLong(1);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JdbcUtils.release(resultSet, preparedStatement);
		}
		return id;
	}

	// 查询一个对象
	public T query(String sql, Object... args)
	{
		Connection connection = null;
		try
		{
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
