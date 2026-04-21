package br.com.wappalarme.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import br.com.wappalarme.data.model.MessageStatus;
import br.com.wappalarme.data.model.ScheduledMessageEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ScheduledMessageDao_Impl implements ScheduledMessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ScheduledMessageEntity> __insertionAdapterOfScheduledMessageEntity;

  private final EntityDeletionOrUpdateAdapter<ScheduledMessageEntity> __deletionAdapterOfScheduledMessageEntity;

  private final EntityDeletionOrUpdateAdapter<ScheduledMessageEntity> __updateAdapterOfScheduledMessageEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessageStatus;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsSent;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsFailed;

  private final SharedSQLiteStatement __preparedStmtOfCancelMessage;

  public ScheduledMessageDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScheduledMessageEntity = new EntityInsertionAdapter<ScheduledMessageEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `scheduled_messages` (`id`,`contactName`,`phoneNumber`,`message`,`scheduledAt`,`status`,`workerId`,`createdAt`,`sentAt`,`errorMessage`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScheduledMessageEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getContactName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContactName());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhoneNumber());
        }
        if (entity.getMessage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getMessage());
        }
        statement.bindLong(5, entity.getScheduledAt());
        statement.bindString(6, __MessageStatus_enumToString(entity.getStatus()));
        if (entity.getWorkerId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getWorkerId());
        }
        statement.bindLong(8, entity.getCreatedAt());
        if (entity.getSentAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getSentAt());
        }
        if (entity.getErrorMessage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getErrorMessage());
        }
      }
    };
    this.__deletionAdapterOfScheduledMessageEntity = new EntityDeletionOrUpdateAdapter<ScheduledMessageEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `scheduled_messages` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScheduledMessageEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfScheduledMessageEntity = new EntityDeletionOrUpdateAdapter<ScheduledMessageEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `scheduled_messages` SET `id` = ?,`contactName` = ?,`phoneNumber` = ?,`message` = ?,`scheduledAt` = ?,`status` = ?,`workerId` = ?,`createdAt` = ?,`sentAt` = ?,`errorMessage` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScheduledMessageEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getContactName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContactName());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhoneNumber());
        }
        if (entity.getMessage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getMessage());
        }
        statement.bindLong(5, entity.getScheduledAt());
        statement.bindString(6, __MessageStatus_enumToString(entity.getStatus()));
        if (entity.getWorkerId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getWorkerId());
        }
        statement.bindLong(8, entity.getCreatedAt());
        if (entity.getSentAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getSentAt());
        }
        if (entity.getErrorMessage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getErrorMessage());
        }
        statement.bindLong(11, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateMessageStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE scheduled_messages SET status = ?, workerId = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkAsSent = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE scheduled_messages SET status = 'SENT', sentAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkAsFailed = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE scheduled_messages SET status = 'FAILED', errorMessage = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfCancelMessage = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE scheduled_messages SET status = 'CANCELLED' WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertMessage(final ScheduledMessageEntity message,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfScheduledMessageEntity.insertAndReturnId(message);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMessage(final ScheduledMessageEntity message,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfScheduledMessageEntity.handle(message);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateMessage(final ScheduledMessageEntity message,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfScheduledMessageEntity.handle(message);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateMessageStatus(final long id, final MessageStatus status,
      final String workerId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessageStatus.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, __MessageStatus_enumToString(status));
        _argIndex = 2;
        if (workerId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, workerId);
        }
        _argIndex = 3;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateMessageStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsSent(final long id, final long sentAt,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsSent.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, sentAt);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfMarkAsSent.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsFailed(final long id, final String error,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsFailed.acquire();
        int _argIndex = 1;
        if (error == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, error);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfMarkAsFailed.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object cancelMessage(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfCancelMessage.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfCancelMessage.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ScheduledMessageEntity>> getAllMessages() {
    final String _sql = "SELECT * FROM scheduled_messages ORDER BY scheduledAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scheduled_messages"}, new Callable<List<ScheduledMessageEntity>>() {
      @Override
      @NonNull
      public List<ScheduledMessageEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contactName");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfScheduledAt = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledAt");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfWorkerId = CursorUtil.getColumnIndexOrThrow(_cursor, "workerId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "sentAt");
          final int _cursorIndexOfErrorMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "errorMessage");
          final List<ScheduledMessageEntity> _result = new ArrayList<ScheduledMessageEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScheduledMessageEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final long _tmpScheduledAt;
            _tmpScheduledAt = _cursor.getLong(_cursorIndexOfScheduledAt);
            final MessageStatus _tmpStatus;
            _tmpStatus = __MessageStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpWorkerId;
            if (_cursor.isNull(_cursorIndexOfWorkerId)) {
              _tmpWorkerId = null;
            } else {
              _tmpWorkerId = _cursor.getString(_cursorIndexOfWorkerId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpSentAt;
            if (_cursor.isNull(_cursorIndexOfSentAt)) {
              _tmpSentAt = null;
            } else {
              _tmpSentAt = _cursor.getLong(_cursorIndexOfSentAt);
            }
            final String _tmpErrorMessage;
            if (_cursor.isNull(_cursorIndexOfErrorMessage)) {
              _tmpErrorMessage = null;
            } else {
              _tmpErrorMessage = _cursor.getString(_cursorIndexOfErrorMessage);
            }
            _item = new ScheduledMessageEntity(_tmpId,_tmpContactName,_tmpPhoneNumber,_tmpMessage,_tmpScheduledAt,_tmpStatus,_tmpWorkerId,_tmpCreatedAt,_tmpSentAt,_tmpErrorMessage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ScheduledMessageEntity>> getPendingMessages() {
    final String _sql = "SELECT * FROM scheduled_messages WHERE status = 'PENDING' ORDER BY scheduledAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scheduled_messages"}, new Callable<List<ScheduledMessageEntity>>() {
      @Override
      @NonNull
      public List<ScheduledMessageEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contactName");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfScheduledAt = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledAt");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfWorkerId = CursorUtil.getColumnIndexOrThrow(_cursor, "workerId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "sentAt");
          final int _cursorIndexOfErrorMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "errorMessage");
          final List<ScheduledMessageEntity> _result = new ArrayList<ScheduledMessageEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScheduledMessageEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final long _tmpScheduledAt;
            _tmpScheduledAt = _cursor.getLong(_cursorIndexOfScheduledAt);
            final MessageStatus _tmpStatus;
            _tmpStatus = __MessageStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpWorkerId;
            if (_cursor.isNull(_cursorIndexOfWorkerId)) {
              _tmpWorkerId = null;
            } else {
              _tmpWorkerId = _cursor.getString(_cursorIndexOfWorkerId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpSentAt;
            if (_cursor.isNull(_cursorIndexOfSentAt)) {
              _tmpSentAt = null;
            } else {
              _tmpSentAt = _cursor.getLong(_cursorIndexOfSentAt);
            }
            final String _tmpErrorMessage;
            if (_cursor.isNull(_cursorIndexOfErrorMessage)) {
              _tmpErrorMessage = null;
            } else {
              _tmpErrorMessage = _cursor.getString(_cursorIndexOfErrorMessage);
            }
            _item = new ScheduledMessageEntity(_tmpId,_tmpContactName,_tmpPhoneNumber,_tmpMessage,_tmpScheduledAt,_tmpStatus,_tmpWorkerId,_tmpCreatedAt,_tmpSentAt,_tmpErrorMessage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getMessageById(final long id,
      final Continuation<? super ScheduledMessageEntity> $completion) {
    final String _sql = "SELECT * FROM scheduled_messages WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ScheduledMessageEntity>() {
      @Override
      @Nullable
      public ScheduledMessageEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contactName");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfScheduledAt = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledAt");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfWorkerId = CursorUtil.getColumnIndexOrThrow(_cursor, "workerId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "sentAt");
          final int _cursorIndexOfErrorMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "errorMessage");
          final ScheduledMessageEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final long _tmpScheduledAt;
            _tmpScheduledAt = _cursor.getLong(_cursorIndexOfScheduledAt);
            final MessageStatus _tmpStatus;
            _tmpStatus = __MessageStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpWorkerId;
            if (_cursor.isNull(_cursorIndexOfWorkerId)) {
              _tmpWorkerId = null;
            } else {
              _tmpWorkerId = _cursor.getString(_cursorIndexOfWorkerId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpSentAt;
            if (_cursor.isNull(_cursorIndexOfSentAt)) {
              _tmpSentAt = null;
            } else {
              _tmpSentAt = _cursor.getLong(_cursorIndexOfSentAt);
            }
            final String _tmpErrorMessage;
            if (_cursor.isNull(_cursorIndexOfErrorMessage)) {
              _tmpErrorMessage = null;
            } else {
              _tmpErrorMessage = _cursor.getString(_cursorIndexOfErrorMessage);
            }
            _result = new ScheduledMessageEntity(_tmpId,_tmpContactName,_tmpPhoneNumber,_tmpMessage,_tmpScheduledAt,_tmpStatus,_tmpWorkerId,_tmpCreatedAt,_tmpSentAt,_tmpErrorMessage);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getOverdueMessages(final long now,
      final Continuation<? super List<ScheduledMessageEntity>> $completion) {
    final String _sql = "SELECT * FROM scheduled_messages WHERE status = 'PENDING' AND scheduledAt <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, now);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ScheduledMessageEntity>>() {
      @Override
      @NonNull
      public List<ScheduledMessageEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contactName");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfScheduledAt = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduledAt");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfWorkerId = CursorUtil.getColumnIndexOrThrow(_cursor, "workerId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "sentAt");
          final int _cursorIndexOfErrorMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "errorMessage");
          final List<ScheduledMessageEntity> _result = new ArrayList<ScheduledMessageEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScheduledMessageEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final long _tmpScheduledAt;
            _tmpScheduledAt = _cursor.getLong(_cursorIndexOfScheduledAt);
            final MessageStatus _tmpStatus;
            _tmpStatus = __MessageStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpWorkerId;
            if (_cursor.isNull(_cursorIndexOfWorkerId)) {
              _tmpWorkerId = null;
            } else {
              _tmpWorkerId = _cursor.getString(_cursorIndexOfWorkerId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpSentAt;
            if (_cursor.isNull(_cursorIndexOfSentAt)) {
              _tmpSentAt = null;
            } else {
              _tmpSentAt = _cursor.getLong(_cursorIndexOfSentAt);
            }
            final String _tmpErrorMessage;
            if (_cursor.isNull(_cursorIndexOfErrorMessage)) {
              _tmpErrorMessage = null;
            } else {
              _tmpErrorMessage = _cursor.getString(_cursorIndexOfErrorMessage);
            }
            _item = new ScheduledMessageEntity(_tmpId,_tmpContactName,_tmpPhoneNumber,_tmpMessage,_tmpScheduledAt,_tmpStatus,_tmpWorkerId,_tmpCreatedAt,_tmpSentAt,_tmpErrorMessage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Integer> getPendingCount() {
    final String _sql = "SELECT COUNT(*) FROM scheduled_messages WHERE status = 'PENDING'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scheduled_messages"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __MessageStatus_enumToString(@NonNull final MessageStatus _value) {
    switch (_value) {
      case PENDING: return "PENDING";
      case SENDING: return "SENDING";
      case SENT: return "SENT";
      case FAILED: return "FAILED";
      case CANCELLED: return "CANCELLED";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private MessageStatus __MessageStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "PENDING": return MessageStatus.PENDING;
      case "SENDING": return MessageStatus.SENDING;
      case "SENT": return MessageStatus.SENT;
      case "FAILED": return MessageStatus.FAILED;
      case "CANCELLED": return MessageStatus.CANCELLED;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
