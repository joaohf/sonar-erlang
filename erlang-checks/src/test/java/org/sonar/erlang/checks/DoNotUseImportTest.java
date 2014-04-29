/*
 * Sonar Erlang Plugin
 * Copyright (C) 2012 Tamas Kende
 * kende.tamas@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.erlang.checks;

import com.sonar.sslr.squid.checks.CheckMessagesVerifier;
import org.junit.Test;
import org.sonar.squid.api.SourceFile;

import java.io.File;

public class DoNotUseImportTest {

  @Test
  public void test() {
    DoNotUseImportCheck check = new DoNotUseImportCheck();

    SourceFile file = TestHelper.scanSingleFile(new File(
      "src/test/resources/checks/funargs.erl"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages()).noMore();
  }

  @Test
  public void test2() {
    DoNotUseImportCheck check = new DoNotUseImportCheck();
    SourceFile file = TestHelper.scanSingleFile(new File(
      "src/test/resources/checks/donotuseimport.erl"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages()).next().atLine(2).withMessage(
      "Do not use import");
  }
}
