/*
 * Copyright 2011 Foundation for On-Line Genealogy, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.folg.gedcom.model;

/**
 * User: Dallan
 * Date: 12/27/11
 *
 * add: FatherRelationship, MotherRelationship
 */
public class ChildRef extends SpouseRef {
   private ParentRelationship _frel = null;
   private ParentRelationship _mrel = null;

   public ParentRelationship getFatherRelationship() {
      return _frel;
   }

   public void setFatherRelationship(ParentRelationship frel) {
      this._frel = frel;
   }

   public ParentRelationship getMotherRelationship() {
      return _mrel;
   }

   public void setMotherRelationship(ParentRelationship mrel) {
      this._mrel = mrel;
   }

   public void accept(Visitor visitor) {
      if (visitor.visit(this)) {
         if (_frel != null) {
            _frel.accept(visitor, true);
         }
         if (_mrel != null) {
            _mrel.accept(visitor, false);
         }
         super.visitContainedObjects(visitor);
         visitor.endVisit(this);
      }
   }
}
