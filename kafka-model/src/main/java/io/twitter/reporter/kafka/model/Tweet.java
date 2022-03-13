/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.twitter.reporter.kafka.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Tweet extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4610434572265179799L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Tweet\",\"namespace\":\"io.twitter.reporter.kafka.model\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"userId\",\"type\":\"long\"},{\"name\":\"text\",\"type\":[\"null\",\"string\"]},{\"name\":\"createAt\",\"type\":[\"null\",\"long\"],\"logicalType\":[\"null\",\"date\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Tweet> ENCODER =
      new BinaryMessageEncoder<Tweet>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Tweet> DECODER =
      new BinaryMessageDecoder<Tweet>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Tweet> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Tweet> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Tweet> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Tweet>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Tweet to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Tweet from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Tweet instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Tweet fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long id;
  private long userId;
  private java.lang.CharSequence text;
  private java.lang.Long createAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Tweet() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param userId The new value for userId
   * @param text The new value for text
   * @param createAt The new value for createAt
   */
  public Tweet(java.lang.Long id, java.lang.Long userId, java.lang.CharSequence text, java.lang.Long createAt) {
    this.id = id;
    this.userId = userId;
    this.text = text;
    this.createAt = createAt;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return userId;
    case 2: return text;
    case 3: return createAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: userId = (java.lang.Long)value$; break;
    case 2: text = (java.lang.CharSequence)value$; break;
    case 3: createAt = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public long getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'userId' field.
   * @return The value of the 'userId' field.
   */
  public long getUserId() {
    return userId;
  }


  /**
   * Sets the value of the 'userId' field.
   * @param value the value to set.
   */
  public void setUserId(long value) {
    this.userId = value;
  }

  /**
   * Gets the value of the 'text' field.
   * @return The value of the 'text' field.
   */
  public java.lang.CharSequence getText() {
    return text;
  }


  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.CharSequence value) {
    this.text = value;
  }

  /**
   * Gets the value of the 'createAt' field.
   * @return The value of the 'createAt' field.
   */
  public java.lang.Long getCreateAt() {
    return createAt;
  }


  /**
   * Sets the value of the 'createAt' field.
   * @param value the value to set.
   */
  public void setCreateAt(java.lang.Long value) {
    this.createAt = value;
  }

  /**
   * Creates a new Tweet RecordBuilder.
   * @return A new Tweet RecordBuilder
   */
  public static io.twitter.reporter.kafka.model.Tweet.Builder newBuilder() {
    return new io.twitter.reporter.kafka.model.Tweet.Builder();
  }

  /**
   * Creates a new Tweet RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Tweet RecordBuilder
   */
  public static io.twitter.reporter.kafka.model.Tweet.Builder newBuilder(io.twitter.reporter.kafka.model.Tweet.Builder other) {
    if (other == null) {
      return new io.twitter.reporter.kafka.model.Tweet.Builder();
    } else {
      return new io.twitter.reporter.kafka.model.Tweet.Builder(other);
    }
  }

  /**
   * Creates a new Tweet RecordBuilder by copying an existing Tweet instance.
   * @param other The existing instance to copy.
   * @return A new Tweet RecordBuilder
   */
  public static io.twitter.reporter.kafka.model.Tweet.Builder newBuilder(io.twitter.reporter.kafka.model.Tweet other) {
    if (other == null) {
      return new io.twitter.reporter.kafka.model.Tweet.Builder();
    } else {
      return new io.twitter.reporter.kafka.model.Tweet.Builder(other);
    }
  }

  /**
   * RecordBuilder for Tweet instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Tweet>
    implements org.apache.avro.data.RecordBuilder<Tweet> {

    private long id;
    private long userId;
    private java.lang.CharSequence text;
    private java.lang.Long createAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.twitter.reporter.kafka.model.Tweet.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.userId)) {
        this.userId = data().deepCopy(fields()[1].schema(), other.userId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.text)) {
        this.text = data().deepCopy(fields()[2].schema(), other.text);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.createAt)) {
        this.createAt = data().deepCopy(fields()[3].schema(), other.createAt);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Tweet instance
     * @param other The existing instance to copy.
     */
    private Builder(io.twitter.reporter.kafka.model.Tweet other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.userId)) {
        this.userId = data().deepCopy(fields()[1].schema(), other.userId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.text)) {
        this.text = data().deepCopy(fields()[2].schema(), other.text);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.createAt)) {
        this.createAt = data().deepCopy(fields()[3].schema(), other.createAt);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public long getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'userId' field.
      * @return The value.
      */
    public long getUserId() {
      return userId;
    }


    /**
      * Sets the value of the 'userId' field.
      * @param value The value of 'userId'.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder setUserId(long value) {
      validate(fields()[1], value);
      this.userId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder clearUserId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'text' field.
      * @return The value.
      */
    public java.lang.CharSequence getText() {
      return text;
    }


    /**
      * Sets the value of the 'text' field.
      * @param value The value of 'text'.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder setText(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.text = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'text' field has been set.
      * @return True if the 'text' field has been set, false otherwise.
      */
    public boolean hasText() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'text' field.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder clearText() {
      text = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'createAt' field.
      * @return The value.
      */
    public java.lang.Long getCreateAt() {
      return createAt;
    }


    /**
      * Sets the value of the 'createAt' field.
      * @param value The value of 'createAt'.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder setCreateAt(java.lang.Long value) {
      validate(fields()[3], value);
      this.createAt = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'createAt' field has been set.
      * @return True if the 'createAt' field has been set, false otherwise.
      */
    public boolean hasCreateAt() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'createAt' field.
      * @return This builder.
      */
    public io.twitter.reporter.kafka.model.Tweet.Builder clearCreateAt() {
      createAt = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Tweet build() {
      try {
        Tweet record = new Tweet();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.userId = fieldSetFlags()[1] ? this.userId : (java.lang.Long) defaultValue(fields()[1]);
        record.text = fieldSetFlags()[2] ? this.text : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.createAt = fieldSetFlags()[3] ? this.createAt : (java.lang.Long) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Tweet>
    WRITER$ = (org.apache.avro.io.DatumWriter<Tweet>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Tweet>
    READER$ = (org.apache.avro.io.DatumReader<Tweet>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.id);

    out.writeLong(this.userId);

    if (this.text == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.text);
    }

    if (this.createAt == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.createAt);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readLong();

      this.userId = in.readLong();

      if (in.readIndex() != 1) {
        in.readNull();
        this.text = null;
      } else {
        this.text = in.readString(this.text instanceof Utf8 ? (Utf8)this.text : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.createAt = null;
      } else {
        this.createAt = in.readLong();
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readLong();
          break;

        case 1:
          this.userId = in.readLong();
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.text = null;
          } else {
            this.text = in.readString(this.text instanceof Utf8 ? (Utf8)this.text : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.createAt = null;
          } else {
            this.createAt = in.readLong();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









