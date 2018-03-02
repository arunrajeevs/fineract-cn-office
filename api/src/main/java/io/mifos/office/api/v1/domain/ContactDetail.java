/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.mifos.office.api.v1.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ContactDetail {

  @NotNull
  private Type type;
  @NotNull
  private Group group;
  @NotBlank
  private String value;
  @Min(1)
  @Max(127)
  private Integer preferenceLevel;
  public ContactDetail() {
    super();
  }

  public String getType() {
    return this.type.name();
  }

  public void setType(final String type) {
    this.type = Type.valueOf(type);
  }

  public String getGroup() {
    return this.group.name();
  }

  public void setGroup(final String group) {
    this.group = Group.valueOf(group);
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public Integer getPreferenceLevel() {
    return this.preferenceLevel;
  }

  public void setPreferenceLevel(final Integer preferenceLevel) {
    this.preferenceLevel = preferenceLevel;
  }

  public enum Type {
    EMAIL,
    PHONE,
    MOBILE
  }

  public enum Group {
    BUSINESS,
    PRIVATE
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactDetail that = (ContactDetail) o;
    return type == that.type &&
            group == that.group &&
            Objects.equals(value, that.value) &&
            Objects.equals(preferenceLevel, that.preferenceLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, group, value, preferenceLevel);
  }

  @Override
  public String toString() {
    return "ContactDetail{" +
            "type=" + type +
            ", group=" + group +
            ", value='" + value + '\'' +
            ", preferenceLevel=" + preferenceLevel +
            '}';
  }
}
