/*
 * Copyright 2015 Webtrends (http://www.webtrends.com)
 *
 * See the LICENCE.txt file distributed with this work for additional
 * information regarding copyright ownership.
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

package com.webtrends.harness.component.etcd

import akka.actor.ActorSystem
import akka.testkit.TestKitBase
import ch.qos.logback.classic.Level
import com.webtrends.harness.component.etcd.config.EtcdTestConfig
import com.webtrends.harness.service.test.TestHarness
import org.junit.runner.RunWith
import org.specs2.mutable.SpecificationLike
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class TestKitSpecificationWithJUnit(_system: ActorSystem) extends {
  implicit val system = _system
} with TestKitBase with SpecificationLike {
  TestHarness(EtcdTestConfig.config, None, Some(Map("wookie-etcd" -> classOf[EtcdManager])), Level.ALL)
  Thread.sleep(1000)
  //implicit val actorSystem = TestHarness.system.get
  val etcdManager = TestHarness.harness.get.getComponent("wookie-etcd").get
}