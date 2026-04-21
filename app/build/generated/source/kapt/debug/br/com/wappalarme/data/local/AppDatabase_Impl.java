package br.com.wappalarme.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile AlarmDao _alarmDao;

  private volatile ScheduledMessageDao _scheduledMessageDao;

  private volatile UserConfigDao _userConfigDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `alarms` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `systemAlarmId` INTEGER NOT NULL, `hour` INTEGER NOT NULL, `minute` INTEGER NOT NULL, `label` TEXT NOT NULL, `daysOfWeek` INTEGER NOT NULL, `isEnabled` INTEGER NOT NULL, `disabledForHoliday` INTEGER NOT NULL, `holidayDisabledDate` TEXT, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `scheduled_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contactName` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `message` TEXT NOT NULL, `scheduledAt` INTEGER NOT NULL, `status` TEXT NOT NULL, `workerId` TEXT, `createdAt` INTEGER NOT NULL, `sentAt` INTEGER, `errorMessage` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_config` (`id` INTEGER NOT NULL, `city` TEXT NOT NULL, `state` TEXT NOT NULL, `cityIbgeCode` TEXT NOT NULL, `checkMunicipalHolidays` INTEGER NOT NULL, `holidayCheckTime` TEXT NOT NULL, `holidayNotificationsEnabled` INTEGER NOT NULL, `lastHolidayCheckDate` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '98c8d82c7cf240bedff9483f197a8026')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `alarms`");
        db.execSQL("DROP TABLE IF EXISTS `scheduled_messages`");
        db.execSQL("DROP TABLE IF EXISTS `user_config`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsAlarms = new HashMap<String, TableInfo.Column>(10);
        _columnsAlarms.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("systemAlarmId", new TableInfo.Column("systemAlarmId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("hour", new TableInfo.Column("hour", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("minute", new TableInfo.Column("minute", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("daysOfWeek", new TableInfo.Column("daysOfWeek", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("disabledForHoliday", new TableInfo.Column("disabledForHoliday", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("holidayDisabledDate", new TableInfo.Column("holidayDisabledDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarms = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlarms = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlarms = new TableInfo("alarms", _columnsAlarms, _foreignKeysAlarms, _indicesAlarms);
        final TableInfo _existingAlarms = TableInfo.read(db, "alarms");
        if (!_infoAlarms.equals(_existingAlarms)) {
          return new RoomOpenHelper.ValidationResult(false, "alarms(br.com.wappalarme.data.model.AlarmEntity).\n"
                  + " Expected:\n" + _infoAlarms + "\n"
                  + " Found:\n" + _existingAlarms);
        }
        final HashMap<String, TableInfo.Column> _columnsScheduledMessages = new HashMap<String, TableInfo.Column>(10);
        _columnsScheduledMessages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("contactName", new TableInfo.Column("contactName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("scheduledAt", new TableInfo.Column("scheduledAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("workerId", new TableInfo.Column("workerId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("sentAt", new TableInfo.Column("sentAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScheduledMessages.put("errorMessage", new TableInfo.Column("errorMessage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScheduledMessages = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScheduledMessages = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScheduledMessages = new TableInfo("scheduled_messages", _columnsScheduledMessages, _foreignKeysScheduledMessages, _indicesScheduledMessages);
        final TableInfo _existingScheduledMessages = TableInfo.read(db, "scheduled_messages");
        if (!_infoScheduledMessages.equals(_existingScheduledMessages)) {
          return new RoomOpenHelper.ValidationResult(false, "scheduled_messages(br.com.wappalarme.data.model.ScheduledMessageEntity).\n"
                  + " Expected:\n" + _infoScheduledMessages + "\n"
                  + " Found:\n" + _existingScheduledMessages);
        }
        final HashMap<String, TableInfo.Column> _columnsUserConfig = new HashMap<String, TableInfo.Column>(8);
        _columnsUserConfig.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("state", new TableInfo.Column("state", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("cityIbgeCode", new TableInfo.Column("cityIbgeCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("checkMunicipalHolidays", new TableInfo.Column("checkMunicipalHolidays", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("holidayCheckTime", new TableInfo.Column("holidayCheckTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("holidayNotificationsEnabled", new TableInfo.Column("holidayNotificationsEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserConfig.put("lastHolidayCheckDate", new TableInfo.Column("lastHolidayCheckDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserConfig = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserConfig = new TableInfo("user_config", _columnsUserConfig, _foreignKeysUserConfig, _indicesUserConfig);
        final TableInfo _existingUserConfig = TableInfo.read(db, "user_config");
        if (!_infoUserConfig.equals(_existingUserConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "user_config(br.com.wappalarme.data.model.UserConfig).\n"
                  + " Expected:\n" + _infoUserConfig + "\n"
                  + " Found:\n" + _existingUserConfig);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "98c8d82c7cf240bedff9483f197a8026", "3e5593afc17ed641985566758cba19e6");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "alarms","scheduled_messages","user_config");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `alarms`");
      _db.execSQL("DELETE FROM `scheduled_messages`");
      _db.execSQL("DELETE FROM `user_config`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AlarmDao.class, AlarmDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ScheduledMessageDao.class, ScheduledMessageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserConfigDao.class, UserConfigDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public AlarmDao alarmDao() {
    if (_alarmDao != null) {
      return _alarmDao;
    } else {
      synchronized(this) {
        if(_alarmDao == null) {
          _alarmDao = new AlarmDao_Impl(this);
        }
        return _alarmDao;
      }
    }
  }

  @Override
  public ScheduledMessageDao scheduledMessageDao() {
    if (_scheduledMessageDao != null) {
      return _scheduledMessageDao;
    } else {
      synchronized(this) {
        if(_scheduledMessageDao == null) {
          _scheduledMessageDao = new ScheduledMessageDao_Impl(this);
        }
        return _scheduledMessageDao;
      }
    }
  }

  @Override
  public UserConfigDao userConfigDao() {
    if (_userConfigDao != null) {
      return _userConfigDao;
    } else {
      synchronized(this) {
        if(_userConfigDao == null) {
          _userConfigDao = new UserConfigDao_Impl(this);
        }
        return _userConfigDao;
      }
    }
  }
}
