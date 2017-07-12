/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * MIT License
 *
 * Copyright (c) 2016 Vangav
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 * */

/**
 * Community
 * Facebook Group: Vangav Open Source - Backend
 *   fb.com/groups/575834775932682/
 * Facebook Page: Vangav
 *   fb.com/vangav.f
 * 
 * Third party communities for Vangav Backend
 *   - play framework
 *   - cassandra
 *   - datastax
 *   
 * Tag your question online (e.g.: stack overflow, etc ...) with
 *   #vangav_backend
 *   to easier find questions/answers online
 * */

package com.vangav.vos_instagram_jobs.cassandra_keyspaces.ig_app_data;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.vangav.backend.cassandra.keyspaces.Query;
import com.vangav.backend.cassandra.keyspaces.Table;
import com.vangav.backend.cassandra.keyspaces.dispatch_message.QueryDispatchable;

/**
 * GENERATED using JavaClientGeneratorMain.java
 */
/**
 * FollowingTime represents
 *   Table [following_time]
 *   in Keyspace [ig_app_data]
 * 
 * Name: following_time
 * Description:
 *   stores the time when a user followed another user 
 * 
 * Columns:
 *   user_id : uuid
 *   following_user_id : uuid
 *   following_time : bigint

 * Partition Keys: user_id, following_user_id
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: insert
 *   Description:
 *     inserts a new followed user's time 
 *   Prepared Statement:
 *     INSERT INTO ig_app_data.following_time (user_id, following_user_id, 
 *     following_time) VALUES (:user_id, :following_user_id, 
 *     :following_time); 
 *   - Name: delete
 *   Description:
 *     deletes an unfollowed user's time 
 *   Prepared Statement:
 *     DELETE FROM ig_app_data.following_time WHERE user_id = :user_id AND 
 *     following_user_id = :following_user_id; 
 *   - Name: select
 *   Description:
 *     selects a followed user's time 
 *   Prepared Statement:
 *     SELECT following_time FROM ig_app_data.following_time WHERE user_id 
 *     = :user_id AND following_user_id = :following_user_id; 
 * */
public class FollowingTime extends Table {

  private static final String kKeySpaceName =
    "ig_app_data";
  private static final String kTableName =
    "following_time";

  public static final String kUserIdColumnName =
    "user_id";
  public static final String kFollowingUserIdColumnName =
    "following_user_id";
  public static final String kFollowingTimeColumnName =
    "following_time";

  /**
   * Query:
   * Name: insert
   * Description:
   *   inserts a new followed user's time 
   * Prepared Statement:
   *   INSERT INTO ig_app_data.following_time (user_id, following_user_id, 
   *   following_time) VALUES (:user_id, :following_user_id, 
   *   :following_time); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "inserts a new followed user's time ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO ig_app_data.following_time (user_id, following_user_id, "
    + "following_time) VALUES (:user_id, :following_user_id, "
    + ":following_time); ";

  /**
   * Query:
   * Name: delete
   * Description:
   *   deletes an unfollowed user's time 
   * Prepared Statement:
   *   DELETE FROM ig_app_data.following_time WHERE user_id = :user_id AND 
   *   following_user_id = :following_user_id; 
   */
  private static final String kDeleteName =
    "delete";
  private static final String kDeleteDescription =
    "deletes an unfollowed user's time ";
  private static final String kDeletePreparedStatement =
    "DELETE FROM ig_app_data.following_time WHERE user_id = :user_id AND "
    + "following_user_id = :following_user_id; ";

  /**
   * Query:
   * Name: select
   * Description:
   *   selects a followed user's time 
   * Prepared Statement:
   *   SELECT following_time FROM ig_app_data.following_time WHERE user_id 
   *   = :user_id AND following_user_id = :following_user_id; 
   */
  private static final String kSelectName =
    "select";
  private static final String kSelectDescription =
    "selects a followed user's time ";
  private static final String kSelectPreparedStatement =
    "SELECT following_time FROM ig_app_data.following_time WHERE user_id = "
    + ":user_id AND following_user_id = :following_user_id; ";

  /**
   * Constructor FollowingTime
   * @return new FollowingTime Object
   * @throws Exception
   */
  private FollowingTime () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kInsertDescription,
        kInsertName,
        kInsertPreparedStatement),
      new Query (
        kDeleteDescription,
        kDeleteName,
        kDeletePreparedStatement),
      new Query (
        kSelectDescription,
        kSelectName,
        kSelectPreparedStatement));
  }

  private static FollowingTime instance = null;

  /**
   * loadTable
   * OPTIONAL method
   * instance is created either upon calling this method or upon the first call
   *   to singleton instance method i
   * this method is useful for loading upon program start instead of loading
   *   it upon the first use since there's a small time overhead for loading
   *   since all queries are prepared synchronously in a blocking network
   *   operation with Cassandra's server
   * @throws Exception
   */
  public static void loadTable () throws Exception {

    if (instance == null) {

      instance = new FollowingTime();
    }
  }

  /**
   * i
   * @return singleton static instance of FollowingTime
   * @throws Exception
   */
  public static FollowingTime i () throws Exception {

    if (instance == null) {

      instance = new FollowingTime();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   inserts a new followed user's time 
  // Parepared Statement:
  //   INSERT INTO ig_app_data.following_time (user_id, following_user_id, 
  //   following_time) VALUES (:user_id, :following_user_id, 
  //   :following_time); 

  /**
   * getQueryInsert
   * @return Insert Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryInsert (
    ) throws Exception {

    return this.getQuery(kInsertName);
  }

  /**
   * getQueryDispatchableInsert
   * @param userid
   * @param followinguserid
   * @param followingtime
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object userid,
    Object followinguserid,
    Object followingtime) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        userid,
        followinguserid,
        followingtime);
  }

  /**
   * getBoundStatementInsert
   * @param userid
   * @param followinguserid
   * @param followingtime
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object userid,
    Object followinguserid,
    Object followingtime) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        userid,
        followinguserid,
        followingtime);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param userid
   * @param followinguserid
   * @param followingtime
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object userid,
    Object followinguserid,
    Object followingtime) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        userid,
        followinguserid,
        followingtime);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param userid
   * @param followinguserid
   * @param followingtime
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object userid,
    Object followinguserid,
    Object followingtime) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        userid,
        followinguserid,
        followingtime);
  }

  // Query: Delete
  // Description:
  //   deletes an unfollowed user's time 
  // Parepared Statement:
  //   DELETE FROM ig_app_data.following_time WHERE user_id = :user_id AND 
  //   following_user_id = :following_user_id; 

  /**
   * getQueryDelete
   * @return Delete Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryDelete (
    ) throws Exception {

    return this.getQuery(kDeleteName);
  }

  /**
   * getQueryDispatchableDelete
   * @param userid
   * @param followinguserid
   * @return Delete Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableDelete (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQueryDispatchable(
        kDeleteName,
        userid,
        followinguserid);
  }

  /**
   * getBoundStatementDelete
   * @param userid
   * @param followinguserid
   * @return Delete Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementDelete (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQuery(kDeleteName).getBoundStatement(
        userid,
        followinguserid);
  }

  /**
   * executeAsyncDelete
   * executes Delete Query asynchronously
   * @param userid
   * @param followinguserid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncDelete (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQuery(kDeleteName).executeAsync(
        userid,
        followinguserid);
  }

  /**
   * executeSyncDelete
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Delete Query synchronously
   * @param userid
   * @param followinguserid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncDelete (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQuery(kDeleteName).executeSync(
        userid,
        followinguserid);
  }

  // Query: Select
  // Description:
  //   selects a followed user's time 
  // Parepared Statement:
  //   SELECT following_time FROM ig_app_data.following_time WHERE user_id 
  //   = :user_id AND following_user_id = :following_user_id; 

  /**
   * getQuerySelect
   * @return Select Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelect (
    ) throws Exception {

    return this.getQuery(kSelectName);
  }

  /**
   * getQueryDispatchableSelect
   * @param userid
   * @param followinguserid
   * @return Select Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelect (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectName,
        userid,
        followinguserid);
  }

  /**
   * getBoundStatementSelect
   * @param userid
   * @param followinguserid
   * @return Select Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelect (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQuery(kSelectName).getBoundStatement(
        userid,
        followinguserid);
  }

  /**
   * executeAsyncSelect
   * executes Select Query asynchronously
   * @param userid
   * @param followinguserid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelect (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQuery(kSelectName).executeAsync(
        userid,
        followinguserid);
  }

  /**
   * executeSyncSelect
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Select Query synchronously
   * @param userid
   * @param followinguserid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelect (
    Object userid,
    Object followinguserid) throws Exception {

    return
      this.getQuery(kSelectName).executeSync(
        userid,
        followinguserid);
  }

}
