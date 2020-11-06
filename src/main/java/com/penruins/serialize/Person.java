package com.penruins.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 如果可序列化类未显式生命 serialVersionUID 则序列化运行时将基于该类的各个方面计算该类的默认serialVersionUID值，如Java(TM) 对象序列化规范中所述
 * 不过，强烈建议所有可序列化类都显式生命 serialVersionUID值，原因是计算默认的serialVersionUID对类的详细信息具有较高的敏感性，根据编译器实现的不同
 * 可能千差万别，这样在反序列化过程中可能会导致意外的InvalidClassException。因此，为保证serialVersionUID值跨越不同java编译器实现的一致性，序列化
 * 类必须声明一个明确的serialVersionUID值。还强烈建议使用private修饰符显示声明serialVersionID（如果可能），原因是这种声明仅应用于直接声明类
 * serialVersionUID字段作为继承成员没有用处
 *
 * If a serializable class does not explicitly declare a serialVersionUID, then the serialization runtime will calculate a default
 * serialVersionUID value for that class based on various aspects of the class, as described in the Java(TM) Object Serialization
 * Specification. However, it is strongly recommended that all serializable classes explicitly declare serialVersionUID values,
 * since the default serialVersionUID computation is highly sensitive to class details that may very depending on compiler
 * implementations, and can thus result in unexpected InvalidClassException during deserialization. Therefore, to guarantee a
 * consistent serialVersionUID value across different java compiler implementations, a serializable class must declare an explicit
 * serialVersionUID value. It is also strongly advised that explicit serialVersionUID declarations use the private modifier where
 * possible, since such declarations apply only to the immediately declaring class--serialVersionUID fields are not useful as
 * inherited numbers.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
  private String name;
  private int age;
}
