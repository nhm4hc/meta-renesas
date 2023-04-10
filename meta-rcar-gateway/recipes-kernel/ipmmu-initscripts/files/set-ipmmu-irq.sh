#!/bin/sh

# Don't use same CPU
echo 0 > /sys/block/nvme0n1/queue/rq_affinity
# Interrupt use CPU1
echo 2 > /proc/irq/default_smp_affinity
