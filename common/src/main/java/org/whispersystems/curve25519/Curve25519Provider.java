/**
 * Copyright (C) 2014-2016 Open Whisper Systems
 *
 * Licensed according to the LICENSE file in this repository.
 */

package org.whispersystems.curve25519;

interface Curve25519Provider {

  static final int PRIVATE_KEY_LEN = 32;

  boolean isNative();
  byte[] calculateAgreement(byte[] ourPrivate, byte[] theirPublic);
  byte[] generatePublicKey(byte[] privateKey);
  byte[] generatePrivateKey();
  byte[] generatePrivateKey(byte[] random);

  byte[] calculateSignature(byte[] random, byte[] privateKey, byte[] message);
  boolean verifySignature(byte[] publicKey, byte[] message, byte[] signature);
  byte[] calculateUniqueSignature(byte[] random, byte[] privateKey, byte[] message);
  boolean verifyUniqueSignature(byte[] publicKey, byte[] message, byte[] signature);

  byte[] getRandom(int length);

  void setRandomProvider(SecureRandomProvider provider);

}
